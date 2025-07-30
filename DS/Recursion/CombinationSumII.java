package DS.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        //first step is to sort
        Arrays.sort(candidates);
        helper(0, candidates, target, ds, ans);

        return ans;
    }

    public static void helper( int idx, int[] arr, int target, List<Integer> ds, List<List<Integer>> ans ){
        //base case : if target is down to 0
        if(target==0){
            ans.add(new ArrayList<>(ds));
            return;
        }

        //loop through all possible indices from [curr..n-1]

        for(int i=idx; i<arr.length; i++){

            //it is not the curr element but same as curr element then skip
            if(i>idx && arr[i]==arr[i-1])
            continue;

            //if in any case the current value is greater than target no point to proceed further
            if(arr[i]>target)
            break;

            //take current index;
            ds.add(arr[i]);
            helper(i+1,arr,target-arr[i],ds,ans);
            //remove it before any new combination
            ds.remove(ds.size()-1);
        }
    }
}
