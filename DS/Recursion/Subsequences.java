package DS.Recursion;

import java.util.ArrayList;
import java.util.List;


public class Subsequences {
    public static void main(String[] args) {

        int[] arr = {1,2,1};
        List<Integer> list = new ArrayList<>();
        //generateSubsequences(0, arr, arr.length, list);

        //printSubsequencesWithGivenSum(0, arr.length , arr, 0, 2, list);
        
        //int count = countSubsequencesWithGivenSum(0, arr.length, arr, 0, 2);
        System.out.println(printOneSubsequencesWithGivenSum(0, arr.length, arr, 0, 2, list));
        
    }

    public static void generateSubsequences(int idx,int[] arr,int n, List<Integer> ans){
        if(idx>=n){
           for(Integer num : ans)
           System.out.print(num + " ");

           System.out.println();
           return;
        }

        //for taking the current element
        ans.add(arr[idx]);
        generateSubsequences(idx+1, arr, n, ans);

        //for not taking the current element
        ans.remove(ans.size()-1);
        generateSubsequences(idx+1, arr, n, ans);
    }

    public static void printSubsequencesWithGivenSum(int idx,int n,int[] arr,int currSum,int targetSum,List<Integer> ds){
        if( idx >= n ) {
            if( currSum == targetSum ) {
                for( int num : ds) {
                    System.out.print(num);
                }
                System.out.println();
            }
            return;
        }

        //take
        ds.add(arr[idx]);
        printSubsequencesWithGivenSum(idx+1, n, arr, currSum+arr[idx], targetSum, ds);

        //not take
        ds.remove(ds.size()-1);
        printSubsequencesWithGivenSum(idx+1, n, arr, currSum, targetSum, ds);
    }

    public static int countSubsequencesWithGivenSum(int idx,int n,int[] arr,int currSum,int targetSum){

        if(idx==n){
            return currSum == targetSum ? 1 : 0;
        }

        int ifTaken = countSubsequencesWithGivenSum(idx+1, n, arr, currSum+arr[idx], targetSum);
        int ifNotTaken = countSubsequencesWithGivenSum(idx+1, n, arr, currSum, targetSum);

        return ifTaken + ifNotTaken;
    }

    public static boolean printOneSubsequencesWithGivenSum(int idx,int n,int[] arr,int currSum,int targetSum,List<Integer> ds){
        if(idx==n){
            if(currSum == targetSum) {
                for(int num: ds)
                    System.out.print(num);
                  
                return true;
            }
            return false;
        }
   
        ds.add(arr[idx]);
        if(printOneSubsequencesWithGivenSum(idx+1, n, arr, currSum+arr[idx], targetSum, ds) == true)
        return true;

        ds.remove(ds.size()-1);
        if(printOneSubsequencesWithGivenSum(idx+1, n, arr, currSum, targetSum, ds) == true)
        return true;

        return false;
    }
}
