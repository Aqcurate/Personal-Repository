import java.io.*;
import java.util.Scanner;

/**
 * This class tests out search and sort algorithms.
 * 
 * @author Andrew Quach
 *
 * @version 1.0.0
 */
public class Main {

    /**
     * Array of ints to be sorted/searched through.
     */ 
    int[] data = null;

    /**
     * Method reads data from a given file.
     *
     * @param file the file path
     * @return string containing data in file
     */
    private String getData(String file) {
        Scanner fileInput = null;
        String data = "";
        try {
            fileInput = new Scanner(new File(file));
            // Concatenate all lines from a file together
            while (fileInput.hasNext()) {
                data += fileInput.next();
            }
            fileInput.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Exception: " + e.getMessage());
        }
        return data;
    }

    /**
     * Takes the string of integers delimited by
     * commas and converts it to an integer array.
     *
     * @param data string of integers
     * @return the array of integers
     */
    private int[] formatData(String data) {
        // Delimit by commas
        String[] stringArray = data.split(",");
        // Cast to integer
        int[] intArray = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }
        return intArray;
    }

    /**
     * Sets data instance variable given data file.
     * Reads the file, then formats the file.
     *
     * @param file the filename in input folder
     */
    private void setData(String file) {
        try {
            data = formatData(getData("input/" + file));
        } catch (Exception e) {
            System.exit(1);
        }
    }

    /**
     * Prints out a portion of an array.
     * 
     * @param start the start index
     * @param length how many indices to read
     */
    private void printArray(int start, int length) {
        for (int i = start; i < start+length; i++) {
            System.out.print(data[i] + " ");
        }
    }

    /**
     * Sorts data array using specificed algorithm
     * and returns the amount of time elapsed.
     *
     * @param sort the sort algorithm
     * @return the amount of time the algorithm took
     */
    private long sortAndTime(Sorts sort) {
        long before = System.currentTimeMillis();
        sort.sort(data);
        long after = System.currentTimeMillis();
        return after-before;
    }

    /**
     * Searches data array for a value using specificed 
     * algorithm and returns the amount of time elapsed.
     * 
     * @param search the search algorithm
     * @param value the value to search for
     * @return the amount of time the algorithm took
     */
    private long searchAndTime(Searches search, int value) {
        long before = System.currentTimeMillis();
        long after = System.currentTimeMillis();
        return after-before;
    }

    /**
     * Given an 2-D array, print the corresponding table.
     *
     * @param elapsed the table to format
     */
    private void formatElapsedTable(String[][] elapsed) {
        int col = elapsed[0].length;
        int row = elapsed.length;

        int maxWidth[] = new int[col];

        // Get the maximum character width for each column
        for (String[] rowData : elapsed) {
            for (int i = 0; i < col; i++) {
                if (maxWidth[i] < rowData[i].length())
                    maxWidth[i] = rowData[i].length();
            }
        }

        // Format template for the table
        // Two space gap between columns
        String formatted = "";
        for (int width : maxWidth) {
            formatted += "%-" + (width+2) + "s ";
        }
        formatted += "%n";

        // Print out each row using format template
        for (String[] rowData : elapsed) {
           System.out.printf(formatted, rowData);
        }
    }

    /**
     * Test out a specific sort on a specific file
     * given user input.
     * Scans for user inputted file, the type of sort
     * used. Prints out the first/last 10 elements of
     * sorted array and time elapsed to sort.
     */
    public void testSorts() {
        Scanner s = new Scanner(System.in);
        // Get input file from user and load the data
        System.out.println("Enter a file in 'input/':");
        String file = s.next();
        setData(file); 

        // Get sort type from user and sort the data
        System.out.println("Enter 1 for MergeSort, 2 for SelectionSort, 3 for InsertSort:");
        int sortNumber = s.nextInt();
        SortFactory sortFactory = new SortFactory();
        Sorts sort = sortFactory.getSort(sortNumber);
        long elapsed = sortAndTime(sort);
        
        // Print first 10 and last 10 elements
        System.out.print("First 10 Sorted Elements: ");
        printArray(0, 10);
        System.out.println();

        System.out.print("Last 10 Sorted Elements: ");
        printArray(data.length-10, 10);
        System.out.println();

        // Print time elapsed
        System.out.println("Time Taken: " + elapsed + " ms");
        s.close();
    }

    /**
     * Tests out all sorts on all files and outputs a table
     * of elapsed time.
     */
    public void testAllSorts() {
        // Get all sorts from sortFactory
        SortFactory sortFactory = new SortFactory();
        Sorts[] allSorts = sortFactory.getAllSorts();
        // Input files to be tested
        String[] allFiles = {"input1.txt", "input2.txt", "input3.txt", "input4.txt"};
        String[][] elapsedTable = new String[allSorts.length+1][allFiles.length+1];

        // Empty square on 0, 0 table
        elapsedTable[0][0] = "";

        // Fill in sort labels on left most column
        for (int i = 0; i < allSorts.length; i++) {
            elapsedTable[i+1][0] = allSorts[i].toString();
        }

        // Fill in filename labels on top most row
        for (int i = 0; i < allFiles.length; i++) {
            elapsedTable[0][i+1] = allFiles[i];
        }

        // Fill in the elapsed time for the rest of the table
        for (int i = 0; i < allSorts.length; i++) {
            for (int j = 0; j < allFiles.length; j++) {
                setData(allFiles[j]);
                elapsedTable[i+1][j+1] = Long.toString(sortAndTime(allSorts[i]));
            }
        }
    
        // Format and print the elapsed table
        System.out.println("Elapsed Table (ms): ");
        formatElapsedTable(elapsedTable);
    }

    /**
     * Test out a specific search on a specific file
     * given user input.
     * Scans for user inputted file, the type of search
     * used, and value to be searched for. Prints out 
     * index of found value and time elapsed to search.
     */
    public void testSearches() {
        Scanner s = new Scanner(System.in);

        // Get input file from user and load the data
        System.out.println("Enter a file in 'input/':");
        String file = s.next();
        setData(file); 

        // Sort the data for binary search to work. (Can comment out if not using binary).
        Sorts merge = new Merge();
        merge.sort(data);

        // Get search type from user and search the data
        System.out.println("Enter 1 for SequentialSearch, 2 for BinarySearch:");
        int searchNumber = s.nextInt();
        SearchFactory searchFactory = new SearchFactory();
        Searches search = searchFactory.getSearch(searchNumber);

        // Get value to be searched for
        System.out.println("What number do you want to search for?");
        int value = s.nextInt();

        // TODO: Better way to get both time elapsed + index without
        // running the program twice. Times like these I miss python's
        // ability to return multiple values

        // Get time elapsed to search data
        long elapsed = searchAndTime(search, value);
        
        // Get index of found value        
        int index = search.search(data, value);
        
        // Print out index
        // TODO: Better error handling. ArrayNotSorted exception?
        if (index == -1) System.out.println("Did not find value.");
        else if (index == -2) System.out.println("Data array not sorted.");
        else System.out.println("Found at index: " + index);        

        // Print time elasped
        System.out.println("Time Taken: " + elapsed + " ms");
        s.close();
    }

    /**
     * Tests out all searches on all files, given a value to search for, 
     * and outputs a table of elapsed time.
     */
    public void testAllSearches() {
        // Get all sorts from sortFactory
        SearchFactory searchFactory = new SearchFactory();
        Searches[] allSearches = searchFactory.getAllSearches();
        // Input files to be tested
        String[] allFiles = {"input1.txt", "input2.txt", "input3.txt", "input4.txt"};
        String[][] elapsedTable = new String[allSearches.length+1][allFiles.length+1];
        Sorts merge = new Merge();

        // Empty square on 0, 0 table
        elapsedTable[0][0] = "";
        Scanner s = new Scanner(System.in);
        
        // Get value to search for
        System.out.println("What number do you want to search for?");
        int value = s.nextInt();
        s.close();

        // Fill in sort labels on left most column
        for (int i = 0; i < allSearches.length; i++) {
            elapsedTable[i+1][0] = allSearches[i].toString();
        }

        // Fill in filename labels on top most row
        for (int i = 0; i < allFiles.length; i++) {
            elapsedTable[0][i+1] = allFiles[i];
        }

        // TODO: Reverse nesting to minimize amount of sorting necessary.

        // Fill in the elapsed time for the rest of the table
        for (int i = 0; i < allSearches.length; i++) {
            for (int j = 0; j < allFiles.length; j++) {
                setData(allFiles[j]);
                merge.sort(data);
                elapsedTable[i+1][j+1] = Long.toString(searchAndTime(allSearches[i], value));
            }
        }

        // Print and format the elapsed table
        System.out.println("Elapsed Table (ms): ");
        formatElapsedTable(elapsedTable);
    }

    /**
     * Main method used to test out searches and sorts.
     */ 
    public static void main(String[] args) {
        Main main = new Main();
        // main.testSorts();          // Testing individual sorts
        main.testSearches();       // Testing individual searches
        // main.testAllSorts();       // Testing all sorts
        // main.testAllSearches();    // Testing all searches
    }
}
