package us.to.sstctf;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;

/**
 * Convenience class for getting input from the mymedia.txt file
 * 
 * @author ckinnard
 * @version 3/5/16
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;

/**
 * Convenience class for getting input from the mymedia.txt file
 * 
 * @author ckinnard
 * Edited by Andrew Quach
 * @version 3/5/16
 */
public class MediaFile {
    private static Scanner in;
    private static BufferedWriter out;

    /**
     * Opens a file to be used for input (if not already open),
     * reads a line from the file, and returns the entire line of data.
     * 
     * @return a line of text from the input file
     */
    public static String readString(String file) {
        if (in == null) {
            try {
                in = new Scanner(new File(file));
            }
            catch (Exception e) {
                System.err.println("Cannot open file for input!");
                e.printStackTrace();
            }
        }
        try {
            if (in.hasNext()) {
                String s = in.nextLine();
                return s;
            }
            else {
                return null;
            }
        }
        catch (Exception e) {
            System.err.println("Cannot read  file!");
            e.printStackTrace();
        }
        return null;

    }

    /**
     * Oens a file to be used for output (if not already open),
     * writes a string to the file and wrties a newline.
     * 
     * @param s The string text to be written. Follwing the string, a newline is added to the file.
     */

    public static void writeString(String s, String file) {
        if (out == null) {
            try {
                out = new BufferedWriter(new FileWriter(file, true));
            }
            catch (Exception e) {
                System.err.println("Cannot create file for output!");
                e.printStackTrace();
            }
        }

        try {
            out.write(s);
            // out.newLine();
            // out.write("|");
        }
        catch (Exception e) {
            System.err.println("Cannot write file!");
            e.printStackTrace();
        }

    }

    /**
     * Saves and closes the file (when opened for either input or output). 
     * 
     * Note: If the program terminates before the file is closed,
     * no data will be saved or written to the file.
     */
    public static void saveAndClose() {
        if (in != null) {
            try {
                in.close();
                in = null;
            }
            catch (Exception e) {
                System.err.println("Cannot close input file!");
                e.printStackTrace();
            }
        }      
        if (out != null) {
            try {
                out.close();
                out = null;
            }
            catch (Exception e) {
                System.err.println("Cannot close output file!");
                e.printStackTrace();
            }
        }
    }
}
