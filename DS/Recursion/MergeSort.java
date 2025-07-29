package DS.Recursion;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {3,1,2,4,1,5,2,6,4};

        mergeSort(arr);

        for(int num : arr){
            System.out.print(num + " ");
        }

    }

    public static void mergeSort(int[] arr){
        mS(arr, 0, arr.length-1);
    }

    //Recursive function
    public static void mS(int[] arr, int low, int high){
        if(low>=high)
        return;

        int mid = ( low + high ) / 2;

        //[low..mid]
        mS(arr, low, mid);
        //[mid+1..high]
        mS(arr, mid+1, high);

        mergeArray(arr, low, mid, high);
    }

    public static void mergeArray(int[] arr, int low, int mid, int high){
        int[] temp = new int[high+1];
        int ptr = 0;
        int left = low;
        int right = mid+1;

        while(left<=mid && right<=high){
            if(arr[left] < arr[right]) {
                temp[ptr] = arr[left];
                ptr++;
                left++;
            }else {
                temp[ptr] = arr[right];
                ptr++;
                right++;  
            }
        }

        //For remaining elements in left array 
        while(left<=mid) {
            temp[ptr]=arr[left];
            ptr++;
            left++;
        }

        //For remaining elements in right array
        while(right<=high) {
            temp[ptr]=arr[right];
            ptr++;
            right++;
        }

        for(int i=low;i<=high;i++){
            arr[i]=temp[i-low];
        }
    }
}
