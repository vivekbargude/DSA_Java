
class Main{
    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 1, 9};
        int sum = 15;
        int longestsubarray = longestSubarray(arr,sum);
        System.out.println("The Longest SubArray with sum k is : "+longestsubarray);
    }

    //Brute Force TC-> N*N SC-> constant 
    //For both array containing 
    public static int longestSubarray(int[] nums, int k) {
        
        int n = nums.length;
        int maxLn = 0;
        for(int i=0;i<n;i++){
            int ln =0,sum=0;
            for(int j=i;j<n;j++){
                sum+=nums[j];
                ln++;
                if(sum==k)
                maxLn = Math.max(maxLn, ln);
            }
        }
        return maxLn;
    }

    // public static int longestSubarray(int[] nums, int k) {
        
    // }
}