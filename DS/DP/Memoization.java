package DS.DP;

import java.util.Arrays;

class Memoization {
    public static void main(String[] args) {
        int n=4;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(fibonacci_dp(n, dp));
        System.out.println(factorial_dp(n, dp));
        System.out.println(sumOfN_dp(n, dp));
    }

    public static int fibonacci_dp(int num,int[] dp){
        if(num==0||num==1)
        return num;

        if(dp[num]!=-1)
        return dp[num];

        dp[num]=fibonacci_dp(num-1, dp)+fibonacci_dp(num-2, dp);
        return dp[num];
    }

    public static int factorial_dp(int n,int[] dp){
        if(n==0||n==1)
        return 1;

        if(dp[n]!=-1)
        return dp[n];

        dp[n]=n*factorial_dp(n-1, dp);
        return dp[n];
    }

    public static int sumOfN_dp(int n,int[] dp){
        if(n==0||n==1)
        return n;

        if(dp[n]!=-1)
        return dp[n];

        dp[n]=n+sumOfN_dp(n-1, dp);
        return dp[n];
    }

    
}
