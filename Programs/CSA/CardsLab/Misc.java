package org.sstctf;

import java.util.Arrays;
import java.util.Random;

public class Misc {
	
	public static String weightedCoinFlip() {
		Random rand = new Random();
		double rng = rand.nextDouble();
		if(rng < .66) {
			return "Head";
		}
		return "Tails";
	}

	public static boolean arePermutations(int[] arrA, int[] arrB) {
		if (arrA == null || arrB == null) return false;
		if (arrA.length != arrB.length) return false;
		
		Arrays.sort(arrA);
		Arrays.sort(arrB);
		
		for (int i = 0; i < arrA.length; i++) {
			if (arrA[i] != arrB[i]) return false;
		}
		
		return true;
	}
}
