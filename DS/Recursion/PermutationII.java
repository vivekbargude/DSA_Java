package DS.Recursion;

import java.util.*;


public class PermutationII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        generatePermutationsBySwapping(0, n, nums, ans);
        return ans;
    }

    public static void generatePermutationsBySwapping(int idx, int n, int[] arr, List<List<Integer>> ans){
        //if all index are taken 
        if(idx==n){
            List<Integer> ds = new ArrayList<>();
            for(int num : arr){
                ds.add(num);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }

        //keep the track of used elements at the current level to avoid its reuse
        Set<Integer> st = new HashSet<>();


        //loop and give each element a chance by swapping them with current element at current index
        for(int i = idx; i<n; i++ ){

            //if used previously then skip
            if(st.contains(arr[i]))
            continue;

            //add the number to set and mark it used
            st.add(arr[i]);
            
            //give the ith element the chance to be the curr index of the permutation
            swap(idx, i, arr);

            //explore
            generatePermutationsBySwapping(idx+1, n,arr, ans);

            //keep the element at its place for next round of permutations
            swap(idx, i, arr);
            
        }
    }

    public static void swap(int i, int j,int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
