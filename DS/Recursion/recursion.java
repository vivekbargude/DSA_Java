package DS.Recursion;


//Functions :
//1.Fibonacci (Recursion)
//2.Factorial (functional)
//2.Factorial (parameterised)
//3.Sum of N numbers (functional)
//3.Sum of N numbers (parameterised)
//4.Print 1-N
//5.Print N-1
//6.Print 1-N(Backtrack)
//7.Print N-1(Backtrack)
//8.Reverse Array(Two pointer and single)
//9.Check for string palindrome

class Recursion{
    public static void main(String[] args){
        // System.out.println(fibonacci(4));
        // System.out.println(factorial(4));
        // System.out.println(sumOfN(4));
        // int n =4;
        // int[] dp = new int[n+1];
        // Arrays.fill(dp,-1);

        // print1toN_backtrack(3,3);
        // printNto1_backtrack(1, 3);
        // sumOfN_Parameterised(4,0);

        fact_Parameterised(4,1);

        int[] arr ={1,2,3,4,5};
        reverseSingleVariable(0, 5, arr);
        for(int i=0;i<5;i++)
        System.out.println(arr[i]);

        System.out.println(isPalindromeString(0, "vivek"));
        
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

    public static void fact_Parameterised(int i,int fact){
        if(i<1){
            System.out.println(fact);
            return;
        }

        fact_Parameterised(i-1, fact*i);
    }

    public static int sumOfN(int n){
        if(n==1)
        return 1;

        return n+sumOfN(n-1);
    }

    //sumOfN_Parameterised(4,0);

    public static void sumOfN_Parameterised(int i,int sum){
        if(i<1)
        {
        System.out.println(sum);
        return;
        }

        sumOfN_Parameterised(i-1,sum+i);
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

    public static void reverseTheArray(int low,int high,int[] arr){
        if(low>high)
        return;

        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;

        reverseTheArray(low+1, high-1, arr);
    }

    public static void reverseSingleVariable(int i,int n,int[] arr){
        if(i>=n/2)
        return;

        swap(i, n-i-1, arr);
        reverseSingleVariable(i+1, n, arr);

        
    }

    public static void swap(int low,int high,int[] arr){
        int temp=arr[low];
        arr[low]=arr[high];
        arr[high]=temp;
    } 

    public static boolean isPalindromeString(int i,String s){
        if(i>=s.length()/2)
        return true;

        if(s.charAt(i)!=s.charAt(s.length()-i-1))
          return false;
        return isPalindromeString(i+1, s);
    }

    
    
}