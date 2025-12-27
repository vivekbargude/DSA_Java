// 81. Search in Rotated Sorted Array II

// There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).

// Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].

// Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.

// You must decrease the overall operation steps as much as possible.

 

// Example 1:

// Input: nums = [2,5,6,0,0,1,2], target = 0
// Output: true
// Example 2:

// Input: nums = [2,5,6,0,0,1,2], target = 3
// Output: false
 

// Constraints:

// 1 <= nums.length <= 5000
// -104 <= nums[i] <= 104
// nums is guaranteed to be rotated at some pivot.
// -104 <= target <= 104

public class SearchInRotatedSortedArrayII {


    public boolean search(int[] nums, int target) {
        int n = nums.length;
        return binarySearch(nums, n, target);
    }

    //Optimized Approach : Using Binary Search
    // TC -> Average case : O(logN) and Worst case : O(N/2) due to continuos iterations for shrinking the search space   
    // SC -> O(1)
    public boolean binarySearch(int[] arr, int n , int target) {
        int low = 0, high = n-1;

        while(low<=high) {
            int mid = low + ( high - low ) / 2 ;

            if(arr[mid]==target)
            return true;

            //Edge case 1 : if element at low == mid == high then,
            // i.e it contains duplicate try to eliminate the space by shrinking the array window of low and high 
            if(arr[low]==arr[mid] && arr[mid]==arr[high]) {
                //Shrink the search space if duplicates are present 
                low += 1;
                high -= 1;
                continue; // shrink till the element at low == mid == high condition is metting
            }

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
        return false;
    }
    
}
