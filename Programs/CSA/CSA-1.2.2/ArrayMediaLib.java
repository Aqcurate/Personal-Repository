package us.to.sstctf;

public class ArrayMediaLib {
	public static void main(String[] args) {
		/*
		String[] sharingFriends = {"Tamir", "Otakar", "Stanislav", "Dane"};		
		for (int i = 0; i < sharingFriends.length; i++) {
			System.out.println(sharingFriends[i]);
		}
		*/
		
		/*
		int[] daysBtwnPurchase = {2, 5, 1, 2, 4, 2, 1, 3};
		int total = 0;
		
		for(int days : daysBtwnPurchase) {
			total += days;
		}
		
		System.out.println((double) total / daysBtwnPurchase.length);
		*/
		
		Song[] topTenSongs = 
			{
				new Song("The Twist"),
				new Song("Smooth"),
				new Song("Mack the Knife"),
				new Song("How Do I Live"),
				new Song("Party Rock Anthem"),
				new Song("I Gotta Feeling"),
				new Song("Macarena (Bayside Boys Mix)"),
				new Song("Physical"),
				new Song("You Light Up My Life"),
				new Song("My Jude")
            		};

		/*
		for (Song s: topTenSongs) {
			System.out.println(s.getTitle());
		}
		*/
		
		/*
		for (Song changeSong : topTenSongs) {
			changeSong.setTitle("test");
		}
		*/
       
		/*
		for (Song changeSong: topTenSongs) {
			changeSong = new Song("test");
			System.out.println(changeSong.getTitle());
		}
		*/
       
		/*
		for (int i = 0; i < topTenSongs.length; i++) {
			topTenSongs[i] = new Song("test");
		}
		*/
       
		/*
		for (int i = 0; i < topTenSongs.length; i++) {
			if (i % 3 == 2) {
				topTenSongs[i].setPrice(0.99);
			} else {
				topTenSongs[i].setPrice(1.29);
			}
		}
		*/
        
		/*
		for (Song showSong : topTenSongs) {
			System.out.println(showSong.getTitle());
			System.out.println(showSong.getPrice());
		}
		*/
       
		/*
		for (int i = 0; i < topTenSongs.length && i < 5; i++) {
			System.out.println(topTenSongs[i].getTitle());
		}
		*/
        
		/*
		for (int i = 0; i < topTenSongs.length; i++) {
			if (i % 2 == 0)
				System.out.println(topTenSongs[i].getTitle());
		}
		*/
       
		int counter = 0;
		for (Song showSong : topTenSongs) {
			if (counter % 2 == 0) 
			System.out.println(showSong.getTitle());
		counter++;
		}
	}
}
