/**
 * Sort Factory that returns sort objects.
 * 
 * @author Andrew Quach
 *
 * @version 1.0.0
 */
public class SortFactory {
    /**
     * Convert designated number to sort object.
     * 1 -> Merge Object
     * 2 -> Selection Object
     * 3 -> Insertion Object
     * 
     * @param sortNum the number corresponding to a sort object
     */
    public Sorts getSort(int sortNum) {
        switch(sortNum) {
            case 1:
                return new Merge();
            case 2:
                return new Selection();
            case 3:
                return new Insertion();
            default:
                System.out.println("Invalid Selection.");
                System.exit(1);
                return null;
        }
    }

    /**
     * Array of all sort objects.
     * @return a sort array of all sort objects.
     */
    public Sorts[] getAllSorts() {
        return new Sorts[] {new Merge(), new Selection(), new Insertion()};
    }
}
