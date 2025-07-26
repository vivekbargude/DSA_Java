package DS.Recursion;

//Intuition:
//check for -ve power
//reciprocal the number

public class Pow {
    public static void main(String[] args) {
        System.out.println(myPow_Recursive(2.0, 4));
    }


    public static double myPow(double x, int n) {
        // Convert to long to avoid overflow when n == Integer.MIN_VALUE
        long N = n;
        double result = 1.0;

        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        for (int i = 0; i < N; i++) {
            result *= x;
        }

        return result;
    }

    public static double myPow_Recursive(double x, int n){
        long N = n;

        if(N<0){
            N=-N;
            x=1/x;
        }

        return calculatePow(x,n);
     }

     public static double calculatePow(double x,long n){
        if(n==0)
        return 1.0;

        double half = calculatePow(x,n/2);

        if(n%2==0)
        return half*half;
        else
        return half*half*x;
     }

}
