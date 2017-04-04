/**
 * This class implements Selection Sort Algorithm.
 * 
 * @author Andrew Quach
 *
 * @version 1.0.0
 */
public class Selection extends Sorts {
    /**
     * Sorts data using selection sort algorithm.
     * Overrides sort method in parent class.
     *
     * @param data data to be sorted
     */
    public void sort(int[] data) {
        int min;
        // Loop through data until second to last element
        for (int i = 0; i < data.length-1; i++) {
            min = i;
            // Loop forward from given position to find smallest
            // value
            for (int j = i+1; j < data.length; j++) {
                if (data[j] < data[min]) {
                    min = j;
                }
            }
            // Swap the index w/ the smallest value with current position
            swap(data, i, min);
        }
    }

    /**
     * Name of Algorithm.
     * @return name of algorithm
     */
    public String toString() {
        return "Selection";
    }
}
