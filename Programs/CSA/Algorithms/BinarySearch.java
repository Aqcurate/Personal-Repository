public class BinarySearch extends Searches {
    public int search(int[] data, int value) {
        // For maximum speed, comment out below line
        if (!checkSorted(data)) return -2;

        int low = 0;
        int high = data.length - 1;

        while (high >= low) {
            int mid = (low + high) / 2;
            if (data[mid] == value) return mid;
            if (data[mid] < value) low = mid + 1;
            if (data[mid] > value) high = mid - 1;
        }

        return -1;
    }

    public String toString() {
        return "Binary Search";
    }

    private boolean checkSorted(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i] > data[i+1]) return false;
        }
        return true;
    }
}
