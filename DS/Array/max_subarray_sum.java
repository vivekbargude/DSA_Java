package DS.Array;

// LC -> 53 / MEDIUM 

// Given an integer array nums, find the subarray with the largest sum, and return its sum.

// Example 1:

// Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6
// Explanation: The subarray [4,-1,2,1] has the largest sum 6.
// Example 2:

// Input: nums = [1]
// Output: 1
// Explanation: The subarray [1] has the largest sum 1.

class pqr {
    public static void main(String[] args) {
        int[] arr = {-2,-3,4,-1,-2,1,5,-3};
        int sum = maxSubArray(arr);
        System.out.println("Max Sum is "+sum);
    }

    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            maxSum = Math.max(sum,maxSum);

            if(sum<0)
            sum=0;
        }
        return maxSum;
    }
}
