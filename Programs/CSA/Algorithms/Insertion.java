public class Insertion extends Algorithms {
    public static void sort(int[] data) {
        int j;
        for (int i = 1; i < data.length; i++) {
            j = i;
            while (j > 0 && data[j-1] > data[j]) {
                swap(data, j, j-1);
                j--;
            }
        }
    }
}
