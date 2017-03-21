public class Merge extends Algorithms {
    public static void sort(int[] data) {
        int temp[] = new int[data.length];
        sort(data, temp, 0, data.length - 1); 
    }

    private static void sort(int[] data, int[] temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            sort(data, temp, left, mid);
            sort(data, temp, mid + 1, right);

            merge(data, temp, left, mid, right);
        }
    }

    private static void merge(int[] data, int[] temp, int left, int mid, int right) {
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
