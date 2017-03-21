import java.io.*;
import java.util.Scanner;

public class Algorithms {
    private static String getData(String file) {
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
    
    private static int[] formatData(String data) {
        String[] stringArray = data.split(",");
        int[] intArray = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }
        return intArray;
    }

    protected static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void testSorts() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a file in 'input/':");
        String file = s.next();
        
        int[] data = null;
        try {
            data = formatData(getData("input/" + file));
        } catch (Exception e) {
            System.exit(1);
        }

        System.out.println("Enter 1 for MergeSort, 2 for SelectionSort, 3 for InsertSort:");

        int sortNumber = s.nextInt();
        long before = System.currentTimeMillis();
        switch(sortNumber) {
            case 1:
                Merge.sort(data);
                break;
            case 2:
                Selection.sort(data);
                break;
            case 3:
                Insertion.sort(data);
                break;
            default:
                System.out.println("Invalid Selection.");
                System.exit(1);
        }
        long after = System.currentTimeMillis();
        
        System.out.print("First 10 Sorted Elements: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();

        System.out.print("Last 10 Sorted Elements: ");
        for (int i = data.length-10; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();

        System.out.println("Time Taken: " + (after-before) + " ms");
        s.close();
    }

    public static void testAllSorts() {
        String[] files = {"input1.txt", "input2.txt", "input3.txt", "input4.txt"};
        
    }

    public static void main(String[] args) {
        testSorts();
        System.exit(0);
    }
}
