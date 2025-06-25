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

    
    
}