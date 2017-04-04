/**
 * This class implements Insertion Sort Algorithm.
 * 
 * @author Andrew Quach
 *
 * @version 1.0.0
 */
public class Insertion extends Sorts {
    /**
     * Sorts data using insertion sort algorithm.
     * Overrides sort method in parent class.
     *
     * @param data data to be sorted
     */
    public void sort(int[] data) {
        int j;
        // Loop through data from index 1
        for (int i = 1; i < data.length; i++) {
            j = i;
            // Loop back through the sorted left side and swap
            // the new datum to the correct position
            while (j > 0 && data[j-1] > data[j]) {
                swap(data, j, j-1);
                j--;
            }
        }
    }

    /**
     * Name of Algorithm.
     * @return name of algorithm
     */
    public String toString() {
        return "Insertion";
    }
}
