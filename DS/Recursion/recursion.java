package DS.Recursion;
import java.util.Arrays;


//Functions :
//1.Fibonacci (Recursion)
//2.Factorial (Recursion)
//3.Sum of N numbers (Recursion)
//4.Print 1-N
//5.Print N-1
//6.Print 1-N(Backtrack)
//7.Print N-1(Backtrack)

class Recursion{
    public static void main(String[] args){
        // System.out.println(fibonacci(4));
        // System.out.println(factorial(4));
        // System.out.println(sumOfN(4));
        // int n =4;
        // int[] dp = new int[n+1];
        // Arrays.fill(dp,-1);

        print1toN_backtrack(3,3);
        printNto1_backtrack(1, 3);


        
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

    public static void printNtimes(int i,int n){
        if(i>n)
        return;

        System.out.println("Vivek");
        printNtimes(i+1, n);
    }

    public static void print1toN(int i,int n){
        if(i>n)
        return;

        System.out.println(i);
        print1toN(i+1, n);
    }

    public static void printNto1(int i,int n){
        if(i<1)
        return;

        System.out.println(i);
        printNto1(i-1, n);
    }

    public static void print1toN_backtrack(int i,int n){
        if(i<1)
        return;

        print1toN_backtrack(i-1, n);
        System.out.println(i);
    }

    public static void printNto1_backtrack(int i,int n){
        if(i>n)
        return;

        printNto1_backtrack(i+1, n);
        System.out.println(i);
    }

    
    
}