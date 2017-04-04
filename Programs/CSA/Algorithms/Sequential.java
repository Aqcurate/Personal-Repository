/**
 * This class implements Binary Search Algorithm.
 * 
 * @author Andrew Quach
 *
 * @version 1.0.0
 */
public class Sequential extends Searches {
    /**
     * Searches for data using sequential search algorithm.
     * Overrides search method in parent class.
     *
     * @param data data to be searched through
     * @param value value to be searched for.
     *
     * @return index of value, -1 if not found
     */
    public int search(int[] data, int value) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == value) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Name of Algorithm.
     * @return name of algorithm
     */
    public String toString() {
        return "Sequential";
    }
}
