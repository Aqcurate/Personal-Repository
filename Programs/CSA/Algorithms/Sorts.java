/**
 * Abstract class providing a blueprint for sorts.
 * 
 * @author Andrew Quach
 *
 * @version 1.0.0
 */
public abstract class Sorts {
    /**
     * Swap the value at one index of an array with 
     * the value at another index.
     *
     * @param arr the array given
     * @param i the first index
     * @param j the second index
     */
    protected void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Sorts the data
     * @param data data to be sorted
     */
    public abstract void sort(int data[]);

    /**
     * Name of Algorithm.
     * @return name of algorithm
     */
    public abstract String toString();
}
