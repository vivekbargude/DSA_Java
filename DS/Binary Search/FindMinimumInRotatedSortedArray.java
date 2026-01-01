// 153. Find Minimum in Rotated Sorted Array
// Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

// [4,5,6,7,0,1,2] if it was rotated 4 times.
// [0,1,2,4,5,6,7] if it was rotated 7 times.
// Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

// Given the sorted rotated array nums of unique elements, return the minimum element of this array.

// You must write an algorithm that runs in O(log n) time.

 

// Example 1:

// Input: nums = [3,4,5,1,2]
// Output: 1
// Explanation: The original array was [1,2,3,4,5] rotated 3 times.
// Example 2:

// Input: nums = [4,5,6,7,0,1,2]
// Output: 0
// Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
// Example 3:

// Input: nums = [11,13,15,17]
// Output: 11
// Explanation: The original array was [11,13,15,17] and it was rotated 4 times. 
 

// Constraints:

// n == nums.length
// 1 <= n <= 5000
// -5000 <= nums[i] <= 5000
// All the integers of nums are unique.
// nums is sorted and rotated between 1 and n times.


class Solution {
    public int findMin(int[] nums) {
        return binarySearch(nums);
    }

    // Optimal Approach: Using Binary Search.
    // Time Complexity: O(logN), at every step the search space is reduced to half using binary search.
    // Space Complexity: O(1), constant additonal space is used.
    public int binarySearch(int[] arr) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        int min = Integer.MAX_VALUE;

        while(low<=high){
            int mid = low + ( high - low ) / 2 ;

            //Check if whole current search is already sorted.
            if(arr[low]<=arr[mid] && arr[mid]<=arr[high]){ //arr[low]<=arr[mid] && arr[mid]<=arr[high] -> arr[low]<=arr[high]
                min = Math.min(min,arr[low]);
                break;
            }

            //Find Sorted halfs

            //Left part is sorted hence get its min element and shrink the search space.
            if(arr[low]<=arr[mid]){
                min = Math.min(min,arr[low]);
                low = mid + 1; //Eliminate the sorted part.
            }
            //Right part is sorted hence get its min element and shrink the search space.
            else{
                min = Math.min(min,arr[mid]);
                high = mid - 1; //Eliminate the sorted part.
            }
        }

        return min;
    }
}