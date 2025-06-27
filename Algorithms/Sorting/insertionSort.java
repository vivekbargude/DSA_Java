package Algorithms.Sorting;

class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};

        insertionSort(arr);

        // Print sorted array
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];       // Element to be inserted
            int j = i - 1;

            // Shift elements greater than key to one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Place key at correct position
            arr[j + 1] = key;
        }
    }
}
