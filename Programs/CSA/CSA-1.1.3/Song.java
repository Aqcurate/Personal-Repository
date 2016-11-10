package us.to.sstctf;

public class Song extends Media {

	private double duration;
	private static int numSong;
	private static double totalSongPrice;
	private static int totalSongRating;
	private static double totalSongDuration;
	
	// Constructors
	// Name - Price - Rating - Duration
	public Song() {
		this("", 0.0, 0, 0);
	}
	
	public Song(String title) {
		this(title, 0.0, 0, 0);
	}
	
	public Song(String title, double price) {
		this(title, price, 0, 0);
	}
	
	public Song(String title, double price, int rating) {
		this(title, price, rating, 0);
	}
	
	public Song(String title, double price, int rating, double duration) {
		super(title, price, rating);
		this.duration = duration;
		Song.numSong += 1;
		Song.totalSongPrice += price;
		Song.totalSongRating += rating;
		Song.totalSongDuration += duration;
	}
	
	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}
	
	public String displaySongDuration() {
		return Media.displayDuration(duration);
	}
	
	// Static getters
	public static int getNumSong() {
		return numSong;
	}
	
	public static double getTotalSongPrice() {
		return totalSongPrice;
	}
	
	public static int getTotalSongRating() {
		return totalSongRating;
	}
	
	public static double getTotalSongDuration() {
		return totalSongDuration;
	}
	
	// Calculating averages for song class
	public static double calculateAverageSongPrice() {
		return Media.calculateAverage(totalSongPrice, numSong);
	}
	
	public static double calculateAverageSongRating() {
		return Media.calculateAverage(totalSongRating, numSong);
	}
	
	public static double calculateAverageSongDuration() {
		return Media.calculateAverage(totalSongDuration, numSong);
	}
	
	// Displaying song duration
	public static String displayAverageSongDuration() {
		return Media.displayDuration(Song.calculateAverageSongDuration());
	}
	
	public static String displayTotalSongDuration() {
		return Media.displayDuration(totalSongDuration);
	}

}
