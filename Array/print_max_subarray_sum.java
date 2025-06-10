

class Main {
    public static void main(String[] args) {
        int[] arr = {-2,-3,4,-1,-2,1,5,-3};
        int[] ans = maxSubArrayPrint(arr); 
        
        int start = ans[0];
        int end = ans[1];
        System.out.println("The Array with max sum is : ");
        for(int i =start;i<=end;i++){
            System.out.print(arr[i]+" ");
        }
        // The Array with max sum is : 
        // 4 -1 -2 1 5 
    }

    public static int[] maxSubArrayPrint(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int start = -1,ansStart = -1,ansEnd =-1;
        for(int i=0;i<n;i++){
            if(sum==0){
            start = i;
            }
            sum+=nums[i];
            
            if(sum>maxSum){
                ansStart=start;
                ansEnd=i;
                maxSum = sum;
            }

            if(sum<0)
            sum=0;
        }
        return new int[]{ansStart,ansEnd};
    }
}
