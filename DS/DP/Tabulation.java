package DS.DP;



//Functions:
// 1.Fibonacci (Tabulation)
// 2.Factorial (Tabulation)
// 3.Sum of N numbers (Tabulation)

class tabulation {
    public static void main(String[] args) {
        System.out.println(fibonacci_tab(4));
        System.out.println(factorial_tab(4));
        System.out.println(sumOfN_tab(4));
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
