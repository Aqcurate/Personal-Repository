package us.to.sstctf;

public class Movie extends Media {

	private double duration;
	private static int numMovie;
	private static double totalMoviePrice;
	private static int totalMovieRating;
	private static double totalMovieDuration;
	
	// Constructors
	// Title - Price - Rating - Duration
	public Movie() {
		this("", 0.0, 0, 0);
	}
	
	public Movie(String title) {
		this(title, 0.0, 0, 0);
	}
	
	public Movie(String title, double price) {
		this(title, price, 0, 0);
	}
	
	public Movie(String title, double price, int rating) {
		this(title, price, rating, 0);
	}
	
	public Movie(String title, double price, int rating, double duration) {
		super(title, price, rating);
		this.duration = duration;
		Movie.numMovie += 1;
		Movie.totalMoviePrice += price;
		Movie.totalMovieRating += rating;
		Movie.totalMovieDuration += duration;
	}
	
	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}
	
	public String displayMovieDuration() {
		return Media.displayDuration(duration);
	}
	
	// Static getters
	public static int getNumMovie() {
		return numMovie;
	}
	
	public static double getTotalMoviePrice() {
		return totalMoviePrice;
	}
	
	public static int getTotalMovieRating() {
		return totalMovieRating;
	}
	
	public static double getTotalMovieDuration() {
		return totalMovieDuration;
	}
	
	// Calculating averages for movie
	public static double calculateAverageMoviePrice() {
		return Media.calculateAverage(totalMoviePrice, numMovie);
	}
	
	public static double calculateAverageMovieRating() {
		return Media.calculateAverage(totalMovieRating, numMovie);
	}
	
	public static double calculateAverageMovieDuration() {
		return Media.calculateAverage(totalMovieDuration, numMovie);
	}
	
	// Displaying durations for movie
	public static String displayAverageMovieDuration() {
		return Media.displayDuration(Movie.calculateAverageMovieDuration());
	}
	
	public static String displayTotalMovieDuration() {
		return Media.displayDuration(totalMovieDuration);
	}
	
}
