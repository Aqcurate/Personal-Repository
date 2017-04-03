public class SearchFactory {
    public Searches getSearch(int searchNum) {
        switch(searchNum) {
            case 1:
                return new SequentialSearch();
            case 2:
                return new BinarySearch();
            default:
                System.out.println("Invalid Selection.");
                System.exit(1);
                return null;
        }
    }

    public Searches[] getAllSearches() {
        return new Searches[] {new SequentialSearch(), new BinarySearch()};
    }
}
