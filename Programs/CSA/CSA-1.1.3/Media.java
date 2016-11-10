package us.to.sstctf;

public class Media {
	
	// Common Variables
	private String title;
	private double price;
	private int rating;
	private boolean favorite;
	private static int numMedia;
	private static double totalMediaPrice;
	private static int totalMediaRating;
	
	// Constructors
	// Name - Price - Rating
	public Media() {
		this("", 0.0, 0);
	}
	
	public Media(String title) {
		this(title, 0.0, 0);
	}
	
	public Media(String title, double price) {
		this(title, price, 0);
	}
	
	public Media(String title, double price, int rating){
		this.title = title;
		this.price = price;
		this.rating = rating;
		Media.numMedia += 1;
		Media.totalMediaPrice += price;
		Media.totalMediaRating += rating;
	}

	// Getters and Setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public boolean isFavorite() {
		return favorite;
	}

	public void setFavorite(boolean favorite) {
		this.favorite = favorite;
	}
	
	// Static Getters
	public static int getNumMedia() {
		return numMedia;
	}
	
	public static double getTotalMediaPrice() {
		return totalMediaPrice;
	}
	
	public static int getTotalMediaRating() {
		return totalMediaRating;
	}
	
	
	// Calculate averages
	protected static double calculateAverage(double statistic, int num) {
		double averageStatistic = 0;
		// Calculate averageStatistic
		try {
			averageStatistic = statistic / num;
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		// Round averagePrice
		averageStatistic = Math.round(averageStatistic * 100.0) / 100.0;

		return averageStatistic;
	}
	
	// Display duration improved
	protected static String displayDuration(double duration) {
		duration = Math.round(duration * 100.0) / 100.0;
		int hours = (int) duration / 60;
		int minutes = (int) duration % 60;
		int seconds = (int) ((duration - (hours*60 + minutes))*100);
		return String.format("%02d:%02d:%02d", hours, minutes, seconds);
	}
	
	// Calculate averages for all medias
	public static double calculateAverageMediaPrice() {
		return Media.calculateAverage(totalMediaPrice, numMedia);
	}
	
	public static double calculateAverageMediaRating() {
		return Media.calculateAverage(totalMediaRating, numMedia);
	}
}
