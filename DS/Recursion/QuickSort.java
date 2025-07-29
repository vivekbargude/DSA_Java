package DS.Recursion;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {3,1,2,4,1,5,2,6,4};
        quickSort(arr);

        for(int num : arr){
            System.out.print(num + " ");
        }
    }

    public static void quickSort(int[] arr) {
        qs(arr, 0, arr.length-1);
    }

    public static void qs(int[] arr, int low, int high) {

        //check for more than one element in the array
        if(low<high){
            int partitionIdx = findPartitionIndex(arr, low, high);
            qs(arr, low, partitionIdx-1);
            qs(arr, partitionIdx+1, high);
        }
    }

    public static int findPartitionIndex(int[] arr, int low, int high){

        int i = low;
        int j = high;
        int pivot = arr[low];

        while(i<j){

            //for finding first element greater than pivot
            while( arr[i]<=pivot && i<=high-1  ) {
                i++;
            }

            //for finding first smaller element than pivot
            while( arr[j] > pivot && j>=low+1 ){
                j--  ;
            }

            //if j hasnt crossed i then only swap both the greater and smallest
            if(i<j)
            swap(arr, i, j);
        }

        swap(arr,low,j);
        return j;

    }


    public static void swap(int[] arr, int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
