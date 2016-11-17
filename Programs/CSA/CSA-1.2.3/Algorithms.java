package us.to.sstctf;

import java.util.ArrayList;
import java.util.Arrays;

public class Algorithms {
	
	public static Media[] insertElement(Media[] topMedia, String name, int index) {
		if (topMedia[topMedia.length-1] != null) {
			System.out.println("Error: Either the array is not empty or the format is incorrect.");
			return topMedia;
		}
		
		if(index > topMedia.length-1) {
			System.out.println("Invalid index.");
			return topMedia;
		}
		
		for (int i = topMedia.length-2; i >= index; i--) {
			topMedia[i+1] = topMedia[i];
		}
		
		topMedia[index] = new Song(name);
		
		return topMedia;
	}
	
	public static Media[] deleteElement(Media[] topMedia, String name) { 
		int index = -1;
		
		for (int i = 0; i < topMedia.length; i++) {
			if (topMedia[i].getTitle().equals(name))
				index = i;
		}
		
		if (index == -1) {
			return topMedia;
		}
		
		for (int i = index; i < topMedia.length-1; i++) {
			topMedia[i] = topMedia[i+1]; 
		}
		
		topMedia[topMedia.length-1] = null;
		
		return topMedia;
	}
	
	public static ArrayList<String> secondBest(Media[] topMedia) {
		ArrayList<String> secondBest = new ArrayList<String>();		
		int highest = Integer.MAX_VALUE;
		int secondHighest = Integer.MAX_VALUE;
		
		for (Media m: topMedia) {
			if (m.getRating() < highest) {
				secondHighest = highest;
				highest = m.getRating();
			} else if (m.getRating() < secondHighest) {
				secondHighest = m.getRating();
			}
		}
		
		for (Media m: topMedia) {
			if (m.getRating() == secondHighest) {
				secondBest.add(m.getTitle());
			}
		}
		
		return secondBest;
	}
	
	public static String bestMedia(Media[] topMedia) {
		Media bestMedia = null;
		for (Media m : topMedia) {
			if (bestMedia == null || bestMedia.getRating() > m.getRating()) {
				bestMedia = m;
			}
		}
		return bestMedia.getTitle();
	}
	
	public static String worstMedia(Media[] topMedia) {
		Media worstMedia = null;
		for (Media m : topMedia) {
			if (worstMedia == null || worstMedia.getRating() < m.getRating()) {
				worstMedia = m;
			}
		}
		return worstMedia.getTitle();
	}
	
	public static void main(String[] args) {
		Song[] topTenSongs = 
			{
				new Song("The Twist", 0, 5),
                new Song("Smooth", 0, 3),
                new Song("Mack the Knife", 0, 9),
                new Song("How Do I Live", 0, 4),
                new Song("Party Rock Anthem", 0, 2),
                new Song("I Gotta Feeling", 0, 10),
                new Song("Macarena (Bayside Boys Mix)", 0, 1),
                new Song("Physical", 0, 2),
                new Song("You Light Up My Life", 0, 2),
                new Song("My Jude", 0, 6)
            };
		
		/*
		for (Song s : topTenSongs) {
			System.out.println(s.getTitle() + " | " + s.getRating());
		}
		*/
		
		/*
		System.out.println("The best song is \"" + bestMedia(topTenSongs) + "\".");
		System.out.println("The worst song is \"" + worstMedia(topTenSongs) + "\".");
		*/
		
		/*
		System.out.println("Second Best Size: " + secondBest(topTenSongs).size());
		System.out.println("Second Best Songs: ");
		for (String s : secondBest(topTenSongs)) {
			System.out.println(s);
		}
		*/
		
		System.out.println("\nBefore Deleting:");
		for (Song s : topTenSongs) {
			if (s != null)
				System.out.println(s.getTitle());
		}
		
		topTenSongs = (Song[]) deleteElement(topTenSongs, "How Do I Live");
		
		System.out.println("\nAfter Deleting:");
		for (Song s : topTenSongs) {
			if (s != null)
				System.out.println(s.getTitle());
		}
		
		topTenSongs = (Song[]) insertElement(topTenSongs, "Amazing New Song!", 4);
		
		System.out.println("\nAfter Inserting:");
		for (Song s : topTenSongs) {
			if (s != null)
				System.out.println(s.getTitle());
		}
	}
}
