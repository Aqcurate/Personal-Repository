/**
 * Search Factory that returns search objects.
 * 
 * @author Andrew Quach
 *
 * @version 1.0.0
 */
public class SearchFactory {
    /**
     * Convert designated number to search object.
     * 1 -> Sequential Object
     * 2 -> Binary Object
     * 
     * @param sortNum the number corresponding to a sort object
     * @return search object
     */
    public Searches getSearch(int searchNum) {
        switch(searchNum) {
            case 1:
                return new Sequential();
            case 2:
                return new Binary();
            default:
                System.out.println("Invalid Selection.");
                System.exit(1);
                return null;
        }
    }

    /**
     * Array of all search objects.
     * @return a search array of all search objects.
     */
    public Searches[] getAllSearches() {
        return new Searches[] {new Sequential(), new Binary()};
    }
}
