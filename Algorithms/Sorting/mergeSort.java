package DS.Array.Sorting;

class Mergesort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 6, 2, 7, 4, 1};

        Mergesort ms = new Mergesort();
        ms.mergeSort(arr, 0, arr.length - 1);

        // Print sorted array
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    void mergeSort(int[] arr, int low, int high) {
        if (low >= high) return;

        int mid = low + (high - low) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);

        merge(arr, low, mid, high);
    }

    void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];

        int i = low;      // pointer for left half
        int j = mid + 1;  // pointer for right half
        int k = 0;        // pointer for temp array

        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // Copy remaining elements of left half
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy remaining elements of right half
        while (j <= high) {
            temp[k++] = arr[j++];
        }

        // Copy sorted elements back to original array
        for (int x = 0; x < temp.length; x++) {
            arr[low + x] = temp[x];
        }
    }
}
