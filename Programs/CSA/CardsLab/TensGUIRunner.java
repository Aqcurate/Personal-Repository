package org.sstctf;

public class TensGUIRunner {
	/**
	 * Plays the GUI version of Elevens.
	 * @param args is not used.
	 */
	public static void main(String[] args) {
		Board board = new TensBoard();
		CardGameGUI gui = new CardGameGUI(board);
		gui.displayGame();
	}
}
