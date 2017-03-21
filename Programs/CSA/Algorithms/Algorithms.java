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

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void insertionSort(int[] data) {
        int j;
        for (int i = 1; i < data.length; i++) {
            j = i;
            while (j > 0 && data[j-1] > data[j]) {
                swap(data, j, j-1);
                j--;
            }
        }
    }

    public static void selectionSort(int[] data) {
        int min;
        for (int i = 0; i < data.length-1; i++) {
            min = i;
            for (int j = i+1; j < data.length; j++) {
                if (data[j] < data[min]) {
                    min = j;
                }
            }
            swap(data, i, min);
        }
    }
    
    public static void mergeSort(int[] data) {
        int temp[] = new int[data.length];
        mergeSort(data, temp, 0, data.length - 1); 
    }

    private static void mergeSort(int[] data, int[] temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(data, temp, left, mid);
            mergeSort(data, temp, mid + 1, right);

            mergeHalves(data, temp, left, mid, right);
        }
    }

    private static void mergeHalves(int[] data, int[] temp, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = data[i];
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                data[k] = temp[i];
                i++;
            } else {
                data[k] = temp[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            data[k] = temp[i];
            i++;
            k++;
        }
    }

    public static void printSorts() {
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
                mergeSort(data);
                break;
            case 2:
                selectionSort(data);
                break;
            case 3:
                insertionSort(data);
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
    }

    public static void main(String[] args) {
        printSorts();
        System.exit(0);
    }
}
