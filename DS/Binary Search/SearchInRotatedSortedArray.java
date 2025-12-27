// 33. Search in Rotated Sorted Array

// There is an integer array nums sorted in ascending order (with distinct values).

// Prior to being passed to your function, nums is possibly left rotated at an unknown index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be left rotated by 3 indices and become [4,5,6,7,0,1,2].

// Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

// You must write an algorithm with O(log n) runtime complexity.

 

// Example 1:

// Input: nums = [4,5,6,7,0,1,2], target = 0
// Output: 4
// Example 2:

// Input: nums = [4,5,6,7,0,1,2], target = 3
// Output: -1
// Example 3:

// Input: nums = [1], target = 0
// Output: -1

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int n = nums.length;
        return binarySearch(nums,n,target);
    }

    //Optimized Approach : Using Binary Search
    // TC -> O(logN)
    // SC -> O(1)

    //Check for sorted and unsorted half
    //Check where the element is present and eliminate the opposite half
    public int binarySearch(int[] arr, int n , int target) {
        int low = 0, high = n-1;

        while(low<=high) {
            int mid = low + ( high - low ) / 2 ;

            if(arr[mid]==target)
            return mid;

            //Left half is sorted
            if(arr[low]<=arr[mid]){
                //If element lies in left half 
                if(arr[low]<=target && target<=arr[mid]){
                    high = mid - 1; //Eliminate right half
                }else{ //If element lies in right half 
                    low = mid + 1; //Eliminate left half
                }

            }else{ //Right half is sorted
                //If element lies in right half 
                if(arr[mid]<=target && target<=arr[high]){
                        low = mid + 1; //Eliminate left half
                }else{ //If element lies in left half 
                        high = mid - 1; //Eliminate right half
                }

            }
        }
        return -1;
    }
}
