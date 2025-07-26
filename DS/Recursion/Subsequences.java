package DS.Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsequences {
    public static void main(String[] args) {

        int[] arr = {3,1,2};
        List<Integer> list = new ArrayList<>();
        generateSubsequences(0, arr, arr.length, list);
        
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
}
