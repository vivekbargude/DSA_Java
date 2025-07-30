package DS.Recursion;
import java.util.ArrayList;
import java.util.List;

public class Subsets {
    
    public static void main(String[] args) {
        int[] arr = {1,2,2};
        List<List<Integer>> ans = new ArrayList<>();

        ans = subsets(arr);

        for(List<Integer> list : ans){
            for(int num : list){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> subs = new ArrayList<>();

        generateSubset(0,n,nums,ans,subs);
        return subs;
        
    }

    public static void generateSubset(int idx,int n,int[] arr,List<Integer> ans,List<List<Integer>> subs){

        if(idx==n){
            subs.add(new ArrayList<>(ans));
            return;
        }

        //take 
        ans.add(arr[idx]);
        generateSubset(idx+1,n,arr,ans,subs);

        //not take
        ans.remove(ans.size()-1);
        generateSubset(idx+1,n,arr,ans,subs);

    }
}
