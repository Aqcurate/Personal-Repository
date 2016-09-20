package us.to.sstctf;
/**
 * This program is for assignment 1.3 of PLW.
 * @author Andrew
 * @version 1.01
 */
import java.util.ArrayList;

public class MediaLib {
	
	public static void main(String[] args) {
		System.out.println("Welcome to your Media Library.");
    	System.out.println();

		
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
        
        // Looping through songs array listing title, price, and rating
        for(Song s: songs) {
        	System.out.println("Title: " + s.getTitle());
        	System.out.println("Price: $" + s.getPrice());
        	System.out.println("Rating: " + s.getRating());
        	System.out.println();
        }
        
        // Printing out average song price and rating
        System.out.println("Average Song Price: " + Song.calculateAverageSongPrice());
        System.out.println("Average Song Rating: " + Song.calculateAverageSongRating());
    	System.out.println();


        // Movie Object - Title / Price / Rating / Duration (Minutes)
        Movie movie1 = new Movie("Infinite Death", 9.24, 3, 97);
        Movie movie2 = new Movie("Double Punishment", 3.42, 2, 134);
        Movie movie3 = new Movie("Extreme Retreat", 6.99, 5, 99);
        
        // Adding to movies array
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        
        // Looping through movies array listing title, price, and rating
        for(Movie m: movies) {
        	System.out.println("Title: " + m.getTitle());
        	System.out.println("Duration: " + m.displayMovieDuration());
        	System.out.println();

        }
        
        // Printing out total and average movie duration
        System.out.println("Total Movie Duration: " + Movie.displayTotalMovieDuration());
        System.out.println("Average Movie Duration: " + Movie.displayAverageMovieDuration());

	}
}
