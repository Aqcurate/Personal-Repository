public class SequentialSearch extends Searches {
    public int search(int[] data, int value) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public String toString() {
        return "Sequential Search";
    }
}
