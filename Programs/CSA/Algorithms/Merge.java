/**
 * This class implements Merge Sort Algorithm.
 * 
 * @author Andrew Quach
 *
 * @version 1.0.0
 */
public class Merge extends Sorts {

    /**
     * Data array given.
     */
    int[] data = null;

    /**
     * Temporary work array with same size as data array.
     */
    int[] temp = null;

    /**
     * Sorts data using merge sort algorithm.
     * Overrides sort method in parent class.
     *
     * Sets data given to data instance variable.
     * Sets a temp array with same size as data array.
     * Calls another version of itself containing the actual
     * algorithm, passing in the array start and end.
     *
     * @param data the data to be sorted
     */
    public void sort(int[] data) {
        this.data = data;
        this.temp = new int[data.length];
        // Pass in the start and end of the array indicies (inclusive)
        sort(0, data.length - 1); 
    }


    /**
     * Divides the array until there are only single units, and
     * merges the units back into a sorted array slowly.
     *
     * Keeps track of the left and right indices of divided units.
     * Does not actually clone broken up array (as to not waste memory).
     * @param left the lower index of subarray
     * @param right the higher index of subarray (inclusive)
     */
    private void sort(int left, int right) {
        // If !left < right, the subarray is a single unit.
        // A subarray of a single unit is considered sorted.
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Breaks up the array into two halves.
            // Sort the left half of the array
            sort(left, mid);
            // Sort the right half of the array
            sort(mid + 1, right);

            // Merge the sorted left half and right half.
            merge(left, mid, right);
        }
    }

    /**
     * Merge the subarrays comparing heads of left and right halves.
     * The merged array will be sorted.
     * 
     * @param left the low index of the left half
     * @param mid the high index of the left half
     * @param right the high index of the right half
     */
    private void merge(int left, int mid, int right) {
        // Copy the left + right halves to work array
        for (int i = left; i <= right; i++) {
            temp[i] = data[i];
        }

        // Copy the head of the left half
        int i = left;
        // Copy the head of the right half
        int j = mid + 1;
        // Index counter
        int k = left;

        // While the halves have not been exhausted
        while (i <= mid && j <= right) {
            // If the left half head is smaller than the right half head
            if (temp[i] <= temp[j]) {
                // Override data with the left half value
                data[k] = temp[i];
                // Increment the head of the left half
                i++;
            // Else
            } else {
                // Override data with the right half value
                data[k] = temp[j];
                // Increment the head of the right half
                j++;
            }
            // Increment the counter
            k++;
        }

        // If the right half has been exhausted, and there remains
        // values on the left half, copy the rest of the values onto
        // the data array. Note, we do not have to do this if the left
        // half gets exhausted first, because the right half data is 
        // already in the correct position.
        while (i <= mid) {
            data[k] = temp[i];
            i++;
            k++;
        }
    }

    /**
     * Name of Algorithm.
     * @return name of algorithm
     */
    public String toString() {
        return "Merge";
    }
}
