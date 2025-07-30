package DS.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public static void main(String[] args) {
        
    }

    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        helper(0, n, nums, ds, ans);

        return ans;
    }

    public static void helper( int idx,int n, int[] arr, List<Integer> ds, List<List<Integer>> ans ){
    
            ans.add(new ArrayList<>(ds));
 
        //loop through all possible indices from [curr..n-1]
        for(int i=idx; i<arr.length; i++){

            //it is not the curr element but same as curr element then skip
            if(i>idx && arr[i]==arr[i-1])
            continue;

            //if in any case the current value is greater than target no point to proceed further

            //take current index;
            ds.add(arr[i]);
            helper(i+1,n,arr,ds,ans);
            //remove it before any new combination
            ds.remove(ds.size()-1);
        }
    }
}
