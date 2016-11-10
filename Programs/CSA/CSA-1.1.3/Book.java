package us.to.sstctf;

public class Book extends Media {
	
	private int pageCount;
	private static int numBook;
	private static double totalBookPrice;
	private static int totalBookRating;
	private static int totalPageCount;
	
	// Constructors
	// Title - Price - Rating - Pages
	public Book() {
		this("", 0.0, 0, 0);
	}
	
	public Book(String title) {
		this(title, 0.0, 0, 0);
	}
	
	public Book(String title, double price) {
		this(title, price, 0, 0);
	}
	
	public Book(String title, double price, int rating) {
		this(title, price, rating, 0);
		Book.numBook += 1;
		Book.totalBookPrice += price;
		Book.totalBookRating += rating;
	}
	
	public Book(String title, double price, int rating, int pages) {
		super(title, price, rating);
		this.setPageCount(pages);
		Book.numBook += 1;
		Book.totalBookPrice += price;
		Book.totalBookRating += rating;
		Book.totalPageCount += pages;
	}
	
	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
	// Static getters
	public static int getNumBook() {
		return numBook;
	}
	
	public static double getTotalBookPrice() {
		return totalBookPrice;
	}
	
	public static int getTotalBookRating() {
		return totalBookRating;
	}
	
	// Calculating averages for books
	public static double calculateAverageBookPrice() {
		return Media.calculateAverage(totalBookPrice, numBook);
	}
	
	public static double calculateAverageBookRating() {
		return Media.calculateAverage(totalBookRating, numBook);
	}
	
	public static double calculateAverageBookPages() {
		return Media.calculateAverage(totalPageCount, numBook);
	}

}
