package us.to.sstctf;

import java.util.ArrayList;

public class LoopingMediaLib {
	public static void printFavorites() {
		System.out.println("My Favorite Songs");
		System.out.println("-----------------");

		String songInfo = MediaFile.readString();

		while (songInfo != null) {
			  int pipeIndex = songInfo.indexOf("|");
			  String title = songInfo.substring(0, pipeIndex);
			  int rating = Integer.valueOf(songInfo.substring(pipeIndex+1));


			  if (rating > 4) {
			   System.out.println(title + "(" + rating + ")");
			  }

			  songInfo = MediaFile.readString();
		}
	}
	public static void main(String[] args) {
		ArrayList<Song> songs = new ArrayList<Song>();
		ArrayList<Movie> movies = new ArrayList<Movie>();
		
		// Song Object - Title / Price / Rating / Duration (Minutes)
		Song song1 = new Song("Johnny B. Goode", 1.29, 5, 2.22);
		Song song2 = new Song("Journey To The End Of Music", 0.99, 3, 2.32);
		Song song3 = new Song("Manic Demon", 0.82, 3, 1.67);
		Song song4 = new Song("Deafening Memory", 9.49, 4, 1.34);
		Song song5 = new Song("City In The Desert", 9.37, 4, 2.20);
		Song song6 = new Song("Golden Passion", 5.26, 1, 3.32);
		Song song7 = new Song("Good Space", 9.21, 1, 4.66);
		Song song8 = new Song("False Fairness", 3.39, 2, 4.31);
		Song song9 = new Song("Lock Up The Virtue", 6.13, 2, 5.19);
		Song song10 = new Song("Overt Ruin", 0.96, 5, 6.14);

		// Adding to songs array
		songs.add(song1);
		songs.add(song2);
		songs.add(song3);
		songs.add(song4);
		songs.add(song5);
		songs.add(song6);
		songs.add(song7);
		songs.add(song8);
		songs.add(song9);
		songs.add(song10);

			/*
		for(Song s: songs) {
			String text = s.getTitle() + "|" + s.getRating() + String.format("%n");
			MediaFile.writeString(text);
		    MediaFile.saveAndClose();
		}
		*/

		/*
		for(int i = 0; i < songs.size()+1; i++) {
			System.out.println(MediaFile.readString());
		}
		*/

		printFavorites();
		}
	}
}
