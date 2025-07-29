package DS.Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        int[] arr = {2,3,6,7};

        combinationSum(0, arr.length, 7, arr, ds, ans);

        for(List<Integer> list : ans){
            for(Integer num: list){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void combinationSum(int i,int n,int target,int[] arr, List<Integer> ds, List<List<Integer>> ans){
        if(i==n){
            if(target==0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        //<= take that element if it is equal to target
        if(arr[i]<=target){
            ds.add(arr[i]);
            combinationSum(i, n, target-arr[i], arr, ds, ans);
            ds.remove(ds.size()-1);
        }

        combinationSum(i+1, n, target, arr, ds, ans);
    }
}
