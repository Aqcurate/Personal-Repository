package us.to.sstctf;

import java.util.ArrayList;

public class TextFileToStoreArray {
	public static ArrayList<Media> readMedia(String file) {
		
		ArrayList<Media> mediaObjects = new ArrayList<Media>();
		String mediaData = MediaFile.readString(file);

		while (mediaData != null) {
			String[] mediaDataArray = mediaData.split("\\|");
			mediaObjects.add(new Media(mediaDataArray[0].trim(), Double.parseDouble(mediaDataArray[2].trim()), Integer.parseInt(mediaDataArray[1].trim())));
			mediaData = MediaFile.readString(file);
		}
		
		MediaFile.saveAndClose();
		
		return mediaObjects;
	}
	
	public static void main(String[] args) {
		System.out.printf("%-15s %-10s %-10s\n", "Title", "Rating", "Price");
		for (Media s : readMedia("mediadata.txt")) {
			System.out.printf("%-15s %-10s %-10s\n", s.getTitle(), s.getRating(), s.getPrice());
		}
	}
	
}