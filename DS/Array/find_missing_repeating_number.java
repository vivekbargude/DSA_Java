package DS.Array;

import java.util.HashMap;

class Main {
    public static void main(String[] args) {
        int[] arr = {3,5,4,1,1};
        int[] ans = findMissingRepeatingNumbers(arr);
        for(int i =0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
    }
    public static int[] findMissingRepeatingNumbers(int[] nums) {
        // int n = nums.length;
        // HashMap<Integer,Integer> map = new HashMap<>();
        // int expSum = (n * (n+1))/2;
        // int[] ans = new int[2];
        // int sum =0;
        // for(int i=0;i<n;i++){
        //     if(map.containsKey(nums[i]))
        //     ans[0]=nums[i];
        //     else{
        //         map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        //         sum+=nums[i];
        //     }
        // }
        // ans[1]=expSum-sum;
        // return ans;

                int n = nums.length;

        // Expected sum of 1 to n: n(n + 1)/2
        long expectedSum = (long)n * (n + 1) / 2;

        // Expected sum of squares of 1 to n: n(n + 1)(2n + 1)/6
        long expectedSquareSum = (long)n * (n + 1) * (2L * n + 1) / 6;

        long actualSum = 0;
        long actualSquareSum = 0;

        // Loop through array and calculate actual sum and square sum
        for (int num : nums) {
            actualSum += num;
            actualSquareSum += (long)num * num;
        }

        // diff = A - B
        long diff = actualSum - expectedSum;

        // squareDiff = A^2 - B^2 = (A - B)(A + B)
        long squareDiff = actualSquareSum - expectedSquareSum;

        // sumAB = A + B = (A^2 - B^2) / (A - B)
        long sumAB = squareDiff / diff;

        // Solving the two equations:
        // A - B = diff
        // A + B = sumAB

        // Add both equations: 2A = diff + sumAB ⇒ A = (diff + sumAB) / 2
        int A = (int)((diff + sumAB) / 2); // Duplicate

        // Now B = A - diff
        int B = (int)(A - diff); // Missing

        return new int[]{A, B};
        
    }
}
