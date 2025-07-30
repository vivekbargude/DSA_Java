package DS.Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsetSum {

    public static void main(String[] args) {
        int[] arr = {3,1,2};
        List<Integer> sums = new ArrayList<>();
    
        generateSubsetSum(0, arr.length, arr, 0, sums);

        Collections.sort(sums);

        for(int sum : sums){
            System.out.print(sum + " ");
        }

    }


    public static void generateSubsetSum(int idx, int n, int[] arr,int currSum, List<Integer> sums){
        //base case 
        //if reached to end of the array then stop 
        if(idx>=n){
            sums.add(currSum);
            return;
        }


        //take the element and add it to sum
        generateSubsetSum(idx+1, n, arr, currSum+arr[idx], sums);

        //dont take element keep sum as it is
        generateSubsetSum(idx+1, n, arr, currSum, sums);
    }
}
