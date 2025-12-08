// You are given a 0-indexed integer array nums and a target element target.

// A target index is an index i such that nums[i] == target.

// Return a list of the target indices of nums after sorting nums in non-decreasing order. If there are no target indices, return an empty list. The returned list must be sorted in increasing order.

 

// Example 1:

// Input: nums = [1,2,5,2,3], target = 2
// Output: [1,2]
// Explanation: After sorting, nums is [1,2,2,3,5].
// The indices where nums[i] == 2 are 1 and 2.
// Example 2:

// Input: nums = [1,2,5,2,3], target = 3
// Output: [3]
// Explanation: After sorting, nums is [1,2,2,3,5].
// The index where nums[i] == 3 is 3.
// Example 3:

// Input: nums = [1,2,5,2,3], target = 5
// Output: [4]
// Explanation: After sorting, nums is [1,2,2,3,5].
// The index where nums[i] == 5 is 4.
 

// Constraints:

// 1 <= nums.length <= 100
// 1 <= nums[i], target <= 100

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTargetIndicesAfterSortingArray {
    public List<Integer> targetIndices(int[] nums, int target) {
        //int n = nums.length;
        return countingSort(nums,target);
    }

    //Approach 1: Brute Force Using Sorting + Linear Search.
    //TC -> O(NlogN) + O(N)
    //SC -> O(1)
    public static List<Integer> linearSearch(int[] nums, int target,int n){
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<n;i++){
            if(nums[i]==target)
            ans.add(i);
        }
        return ans;
    }

    //Approach 1: Better Approach Using Sorting + Binary Search
    //TC -> O(NlogN) + O(logN) + O(logN)
    //SC -> O(1) 
    public static List<Integer> binarySearch(int[] nums, int target,int n){
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        int first = findFirstOccurrence(nums,target,n);
        if(first == -1)
        return ans;
        int last = findLastOccurrence(nums,target,n);

        for(int i=first;i<=last;i++){
            ans.add(i);
        }
        return ans;
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


    //Approach 3: Optimal Approach using Counting Sort
    //TC -> O(N)
    //SC -> O(1)
    public List<Integer> countingSort(int[] nums, int target) {
        int count = 0, lessthan = 0;
        for (int n : nums) {
            if (n == target) count++;
            if (n < target) lessthan++;
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(lessthan++);
        }
        return result;
    }
}
