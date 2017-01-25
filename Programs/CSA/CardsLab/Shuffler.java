package org.sstctf;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Shuffler {
	
	public static List<Card> realisticShuffle(List<Card> list) {
		List<List<Card>> splitDecks = Shuffler.cutCards(list, list.size()/2, 2);
		return Shuffler.mergeCards(splitDecks, 0.50);
	}
	
	public static List<Card> perfectShuffle(List<Card> list) {
		List<List<Card>> splitDecks = Shuffler.cutCards(list, list.size()/2, 0);
		return Shuffler.mergeCards(splitDecks);
	}
	
	public static List<Card> selectionShuffle(List<Card> list) {
		Random rand = new Random();
		for (int i = list.size()-1; i > 0; i--) {
			int rng = rand.nextInt(i);
			Shuffler.swap(list, rng, i);
		}
		return list;
	}
	
	public static void swap(List<Card> list, int a, int b) {
		Card temp = list.set(a, list.get(b));
		list.set(b, temp);
	}
	
	public static List<List<Card>> cutCards(List<Card> list, double mean, double std) {		
		Random rand = new Random();
		int splitPosition = (int) (rand.nextGaussian()*std + mean);
		
		List<List<Card>> splitDecks = new ArrayList<List<Card>>(2); 
		splitDecks.add(new ArrayList<Card>(list.subList(0, splitPosition)));
		splitDecks.add(new ArrayList<Card>(list.subList(splitPosition, list.size())));
		
		return splitDecks;	
	}
	
	public static List<Card> mergeCards(List<List<Card>> splitDecks, double percentChance) {
		Random rand = new Random();
		List<Card> combinedDeck = new ArrayList<Card>();
		
		int combinedSize = splitDecks.get(0).size() + splitDecks.get(1).size();
		
		while (combinedDeck.size() < combinedSize) {
			double rng = rand.nextDouble();
			
			if (rng <= percentChance) {
				combinedDeck.add(splitDecks.get(0).remove(0));
			} else {
				combinedDeck.add(splitDecks.get(1).remove(0));
			}
						
			if (splitDecks.get(0).size() == 0) {
				combinedDeck.addAll(splitDecks.get(1));
				break;
			}
			
			if (splitDecks.get(1).size() == 0) {
				combinedDeck.addAll(splitDecks.get(0));
				break;
			}
		}
		
		return combinedDeck;
	}
		
	public static List<Card> mergeCards(List<List<Card>> splitDecks) {
		List<Card> combinedDeck = new ArrayList<Card>();
		
		int combinedSize = splitDecks.get(0).size() + splitDecks.get(1).size();

		while (combinedDeck.size() < combinedSize) {
			combinedDeck.add(splitDecks.get(0).remove(0));
			combinedDeck.add(splitDecks.get(1).remove(0));
		}
		
		return combinedDeck;
	}
}
