/**
 * This class implements Binary Search Algorithm.
 * 
 * @author Andrew Quach
 *
 * @version 1.0.0
 */
public class Binary extends Searches {
    /**
     * Searches for data using binary search algorithm.
     * Overrides search method in parent class.
     *
     * @param data data to be searched through
     * @param value value to be searched for.
     *
     * @return index of value, -1 if not found, -2 if invalid dataset
     */
    public int search(int[] data, int value) {
        // TODO: Error handling in parent class of unsorted data
        // TODO: Move checkSorted to different class?

        // For maximum speed, comment out below line
        if (!checkSorted(data)) return -2;

        int low = 0;
        int high = data.length - 1;

        while (high >= low) {
            int mid = (low + high) / 2;
            // Data has been found
            if (data[mid] == value) return mid;
            // Narrow it down to the upper half
            if (data[mid] < value) low = mid + 1;
            // Narrow it down to the lower half
            if (data[mid] > value) high = mid - 1;
        }

        // Data not found
        return -1;
    }

    /**
     * Name of Algorithm.
     * @return name of algorithm
     */
    public String toString() {
        return "Binary";
    }

    /**
     * Check if array is sorted.
     * @return whether the array is sorted.
     */
    private boolean checkSorted(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i] > data[i+1]) return false;
        }
        return true;
    }
}
