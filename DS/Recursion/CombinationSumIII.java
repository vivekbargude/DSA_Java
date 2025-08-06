package DS.Recursion;
import java.util.*;;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(k,n,1,new ArrayList<>(),ans);
        return ans;
    }

    static void helper(int k,int n,int start,List<Integer> ds,List<List<Integer>> ans){

        if(ds.size() == k){
            if(n==0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        //traverse all numbers from 1 to 9 to place it in the current index

        for(int i=start;i<=9;i++){
            if(i>n) break;

            //for uniqueness start range from after the current number till 9
            ds.add(i);
            helper(k,n-i,i+1,ds,ans);
            ds.remove(ds.size()-1);
            
        }
        return;
    }
}
