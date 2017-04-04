/**
 * Abstract class providing a blueprint for sorts. 
 * 
 * @author Andrew Quach
 *
 * @version 1.0.0
 */
public abstract class Searches {
    /**
     * Searches for data
     * 
     * @param data data to be searched through
     * @param value value to be searched for
     *
     * @return index of value, -1 if not found, -2 if invalid dataset
     */
    public abstract int search(int data[], int value);

    /**
     * Name of Algorithm.
     * @return name of algorithm
     */
    public abstract String toString();
}
