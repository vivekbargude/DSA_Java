// Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

// If target is not found in the array, return [-1, -1].

// You must write an algorithm with O(log n) runtime complexity.

 

// Example 1:

// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]
// Example 2:

// Input: nums = [5,7,7,8,8,10], target = 6
// Output: [-1,-1]
// Example 3:

// Input: nums = [], target = 0
// Output: [-1,-1]
 

// Constraints:

// 0 <= nums.length <= 10^5
// -10^9 <= nums[i] <= 10^9
// nums is a non-decreasing array.
// -10^9 <= target <= 10^9

public class FirstAndLastOccurrence {

    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        return simpleBinarySearch(nums,target,n);
    }

    //Brute Force Approach 
    //TC -> O(N)
    //SC -> O(1)
    public static int[] linearSearch(int[] nums, int target, int n){
        int first = -1 , last = -1;

        for(int i=0; i<n; i++){
            if(nums[i]==target){
                if(first==-1)
                first = i;

                last = i;
            }
        }
        return new int[]{first,last};
    }

    //Optimal Approach 1: Using Upper and Lower bound.(Two Pass)
    //TC -> O(logN) + O(logN)
    //SC -> O(1)
    public static int[] binarySearch(int[] nums, int target,int n){

        int first = lowerBound(nums,target,n);
        //Element not present in the array.
        //Covering both the edges case for upper as well as lower.
        if(first == n || nums[first]!=target)
        return new int[]{-1,-1};

        int last = upperBound(nums,target,n);

        return new int[]{first,last-1};
    }

    public static int lowerBound(int[] nums, int target, int n){
        int ans = n;
        int low = 0, high = n-1;

        while(low<=high){
            int mid = low + (high-low)/2;

            if(nums[mid]>=target){
                ans = mid;
                high = mid -1;
            }else{
                low = mid+1;
            }
        }

        return ans;
    }

    public static int upperBound(int[] nums, int target,int n){
        int ans = n;
        int low = 0, high = n-1;

        while(low<=high){
            int mid = low + (high-low)/2;

            if(nums[mid]>target){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid+1;
            }
        }

        return ans;
    }

    //Optimized Approach 2: Using simple binary search.(Two Pass)
    //TC -> O(logN) + O(logN)
    //SC -> O(1)
    public static int[] simpleBinarySearch(int[] nums, int target,int n){
        int first = findFirstOccurrence(nums,target,n);
        if(first == -1){
            return new int[]{-1,-1};
        }
        int last = findLastOccurrence(nums,target,n);
        return new int[]{first,last};
    }

    //Binary Search for first occurrence.
    public static int findFirstOccurrence(int[] nums,int target,int n){
        int low = 0,high = n-1;
        int first = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid]==target){
                //got target index but we want first hence going to left portion. 
                first = mid;
                high = mid - 1;
            }else if(nums[mid]>target){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return first;
    }

    //Binary Search for last occurrence.
    public static int findLastOccurrence(int[] nums,int target,int n){
        int low = 0,high = n-1;
        int last = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid]==target){
                //got target index but we want last hence going to right portion. 
                last = mid;
                low = mid + 1;
            }else if(nums[mid]>target){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return last;
    }
}
