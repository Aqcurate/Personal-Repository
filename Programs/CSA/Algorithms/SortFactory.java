public class SortFactory {
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

    public Sorts[] getAllSorts() {
        return new Sorts[] {new Merge(), new Selection(), new Insertion()};
    }
}
