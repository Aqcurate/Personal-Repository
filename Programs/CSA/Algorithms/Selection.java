public class Selection extends Sorts {
    public void sort(int[] data) {
        int min;
        for (int i = 0; i < data.length-1; i++) {
            min = i;
            for (int j = i+1; j < data.length; j++) {
                if (data[j] < data[min]) {
                    min = j;
                }
            }
            swap(data, i, min);
        }
    }

    public String toString() {
        return "Selection";
    }
}
