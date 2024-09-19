public class MergeSort {
    public static void main(String[] args) {
        int[] arr = { 12, 11, 13, 5, 6, 7 };
        MergeSort ob = new MergeSort();
        ob.mergeSort(arr, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int i, int i1) {
        if (i < i1) {
            int m = (i + i1) / 2;
            mergeSort(arr, i, m);
            mergeSort(arr, m + 1, i1);
            merge(arr, i, m, i1);
        }
    }

    private void merge(int[] arr, int i, int m, int i1) {
        int n1 = m - i + 1;
        int n2 = i1 - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int j = 0; j < n1; j++) {
            L[j] = arr[i + j];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[m + 1 + j];
        }

        int x = 0, j = 0;
        int k = x;
        while (x < n1 && j < n2) {
            if (L[x] <= R[j]) {
                arr[k] = L[x];
                x++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (x < n1) {
            arr[k] = L[x];
            x++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }


}
