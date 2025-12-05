public class BinarySearch {
    public int search(int[] nums, int target) {
        
        //return recursiveBS(nums,0,n-1,target);
        return iterativeBS(nums,target);
    }

    //Recursive Solution
    //TC -> O(logN)
    //SC -> O(1)
    public static int recursiveBS(int[] arr, int low, int high, int target){
        //Search Space : arr[low..high]
        // Base Case : If the search space is exhasuted. 
        if(low > high) return -1;

        int mid = low + (high - low) / 2;

        if(arr[mid]==target) return mid;

        else if(arr[mid]<target) return recursiveBS(arr,mid+1,high,target);

        return recursiveBS(arr,low,mid-1,target); 
    }

    //Iterative Solution
    //TC -> O(logN)
    //SC -> O(1)
    public static int iterativeBS(int[] nums, int target){
        int n = nums.length;
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            
            if(nums[mid]==target)
            return mid;
            else if(target > nums[mid])
            low = mid+1;
            else
            high = mid-1;
        }
        return -1;
    }
}
