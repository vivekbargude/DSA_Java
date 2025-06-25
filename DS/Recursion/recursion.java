package DS.Recursion;
import java.util.Arrays;

//Functions :
//1.Fibonacci (Recursion)
//2.Factorial (Recursion)
//3.Sum of N numbers (Recursion)
//4.Fibonacci (Memoization)
//5.Factorial (Memoization)
//6.Sum of N numbers (Memoization)
//7.Fibonacci (Tabulation)
//8.Factorial (Tabulation)
//9.Sum of N numbers (Tabulation)

class Recursion{
    public static void main(String[] args){
        System.out.println(fibonacci(4));
        System.out.println(factorial(4));
        System.out.println(sumOfN(4));
        int n =4;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(sumOfN_tab(n));
        
    }
    public static int fibonacci(int num){
        if(num==0 || num==1)
        return num;

        return fibonacci(num-1)+fibonacci(num-2);
    }

    public static int factorial(int n){
        if(n==1)
        return 1;

        return n*factorial(n-1);
    }

    public static int sumOfN(int n){
        if(n==1)
        return 1;

        return n+sumOfN(n-1);
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

    public static int fibonacci_tab(int n){
        if(n==0||n==1)
        return n;

        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;

        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[n-2];
        }

        return dp[n];
    }

    public static int factorial_tab(int n){
        if(n==0||n==1)
        return 1;

        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;

        for(int i=2;i<=n;i++){
            dp[i]=i*dp[i-1];
        }
        return dp[n];

    }

    public static int sumOfN_tab(int n){
        if(n==0||n==1)
        return n;

        int[] dp = new int[n+1];

        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=i+dp[i-1];
        }
        return dp[n];
    }
    
}