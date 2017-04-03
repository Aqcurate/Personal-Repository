public class Merge extends Sorts {

    int[] data = null;
    int[] temp = null;

    public void sort(int[] data) {
        this.data = data;
        this.temp = new int[data.length];
        sort(0, data.length - 1); 
    }

    public String toString() {
        return "Merge";
    }

    private void sort(int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            sort(left, mid);
            sort(mid + 1, right);

            merge(left, mid, right);
        }
    }

    private void merge(int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = data[i];
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                data[k] = temp[i];
                i++;
            } else {
                data[k] = temp[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            data[k] = temp[i];
            i++;
            k++;
        }
    }
}
