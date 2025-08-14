package DS.Recursion;

public class CountInversion {

    public static void main(String[] args) {
        int[] arr = {5,3,2,1,4};
        mergeSort(arr);
    }

    public static void mergeSort(int[] arr){
        System.out.println(mS(arr, 0, arr.length-1));
    }

    //Recursive function
    public static int mS(int[] arr, int low, int high){
        int cnt = 0;
        if(low>=high)
        return cnt;

        int mid = ( low + high ) / 2;

        //[low..mid]
        cnt += mS(arr, low, mid);
        //[mid+1..high]
        cnt += mS(arr, mid+1, high);

        cnt += mergeArray(arr, low, mid, high);

        return cnt;
    }

    public static int mergeArray(int[] arr, int low, int mid, int high){
        int[] temp = new int[high+1];
        int ptr = 0;
        int left = low;
        int right = mid+1;

        int cnt = 0;

        while(left<=mid && right<=high){
            if(arr[left] < arr[right]) {
                temp[ptr] = arr[left];
                ptr++;
                left++;
            }else {
                temp[ptr] = arr[right];
                cnt += (mid-left +1);
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

        return cnt;
    }
}
