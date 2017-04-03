import java.io.*;
import java.util.Scanner;

public class Main {

    int[] data = null;

    private String getData(String file) {
        Scanner fileInput = null;
        String data = "";
        try {
            fileInput = new Scanner(new File(file));
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

    private int[] formatData(String data) {
        String[] stringArray = data.split(",");
        int[] intArray = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }
        return intArray;
    }

    private void printArray(int start, int length) {
        for (int i = start; i < start+length; i++) {
            System.out.print(data[i] + " ");
        }
    }

    private void setData(String file) {
        try {
            data = formatData(getData("input/" + file));
        } catch (Exception e) {
            System.exit(1);
        }
    }

    private long sortAndTime(Sorts sort) {
        long before = System.currentTimeMillis();
        sort.sort(data);
        long after = System.currentTimeMillis();
        return after-before;
    }

    private long searchAndTime(Searches search, int value) {
        long before = System.currentTimeMillis();
        System.out.println(search.search(data, value));
        long after = System.currentTimeMillis();
        return after-before;
    }

    private void formatElapsedTable(String[][] elapsed) {
        int col = elapsed[0].length;
        int row = elapsed.length;

        int maxWidth[] = new int[col];

        for (String[] rowData : elapsed) {
            for (int i = 0; i < col; i++) {
                if (maxWidth[i] < rowData[i].length())
                    maxWidth[i] = rowData[i].length();
            }
        }

        String formatted = "";
        for (int width : maxWidth) {
            formatted += "%-" + (width+2) + "s ";
        }

        formatted += "%n";

        for (String[] rowData : elapsed) {
           System.out.printf(formatted, rowData);
        }
    }

    public void testSorts() {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter a file in 'input/':");
        String file = s.next();
        setData(file); 

        System.out.println("Enter 1 for MergeSort, 2 for SelectionSort, 3 for InsertSort:");
        int sortNumber = s.nextInt();
        SortFactory sortFactory = new SortFactory();
        Sorts sort = sortFactory.getSort(sortNumber);
        long elapsed = sortAndTime(sort);
        
        System.out.print("First 10 Sorted Elements: ");
        printArray(0, 10);
        System.out.println();

        System.out.print("Last 10 Sorted Elements: ");
        printArray(data.length-10, 10);
        System.out.println();

        System.out.println("Time Taken: " + elapsed + " ms");
        s.close();
    }


    public void testAllSorts() {
        SortFactory sortFactory = new SortFactory();
        Sorts[] allSorts = sortFactory.getAllSorts();
        String[] allFiles = {"input1.txt", "input2.txt", "input3.txt"};
        String[][] elapsedTable = new String[allSorts.length+1][allFiles.length+1];

        elapsedTable[0][0] = "";

        for (int i = 0; i < allSorts.length; i++) {
            elapsedTable[i+1][0] = allSorts[i].toString();
        }

        for (int i = 0; i < allFiles.length; i++) {
            elapsedTable[0][i+1] = allFiles[i];
        }

        for (int i = 0; i < allSorts.length; i++) {
            for (int j = 0; j < allFiles.length; j++) {
                setData(allFiles[j]);
                elapsedTable[i+1][j+1] = Long.toString(sortAndTime(allSorts[i]));
            }
        }

        formatElapsedTable(elapsedTable);
    }

    public void testSearches() {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter a file in 'input/':");
        String file = s.next();
        setData(file); 
        Sorts merge = new Merge();
        merge.sort(data);

        System.out.println("Enter 1 for SequentialSearch, 2 for BinarySearch:");
        int searchNumber = s.nextInt();
        SearchFactory searchFactory = new SearchFactory();
        Searches search = searchFactory.getSearch(searchNumber);

        System.out.println("What number do you want to search for?");
        int value = s.nextInt();

        long elapsed = searchAndTime(search, value);
        int index = search.search(data, value);
        if (index == -1) System.out.println("Did not find value.");
        else if (index == -2) System.out.println("Data array not sorted.");
        else System.out.println("Found at index: " + index);        

        System.out.println("Time Taken: " + elapsed + " ms");
        s.close();
    }

    public void testAllSearches() {
        SearchFactory searchFactory = new SearchFactory();
        Searches[] allSearches = searchFactory.getAllSearches();
        String[] allFiles = {"input1.txt", "input2.txt", "input3.txt", "input4.txt"};
        String[][] elapsedTable = new String[allSearches.length+1][allFiles.length+1];

        elapsedTable[0][0] = "";
        Sorts merge = new Merge();
        Scanner s = new Scanner(System.in);
        
        System.out.println("What number do you want to search for?");
        int value = s.nextInt();
        s.close();

        for (int i = 0; i < allSearches.length; i++) {
            elapsedTable[i+1][0] = allSearches[i].toString();
        }

        for (int i = 0; i < allFiles.length; i++) {
            elapsedTable[0][i+1] = allFiles[i];
        }

        for (int i = 0; i < allSearches.length; i++) {
            for (int j = 0; j < allFiles.length; j++) {
                setData(allFiles[j]);
                merge.sort(data);
                elapsedTable[i+1][j+1] = Long.toString(searchAndTime(allSearches[i], value));
            }
        }

        formatElapsedTable(elapsedTable);
    }

    public static void main(String[] args) {
        Main main = new Main();
        // main.testSorts();
        main.testSearches();
        // main.testAllSorts();
        //main.testAllSearches();
    }
}
