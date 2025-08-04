package DS.Recursion;

import java.util.*;

public class PalindromePartioning {
    public static void main(String[] args) {
        List<List<String>> ans = new ArrayList<>();
        String s = "aabb";
        partitionHelper(0, s, new ArrayList<>(), ans);

        for(List<String> list : ans){
            for(String str : list){
                System.out.print(str+" ");
            }
            System.out.println();
        }
    }

    public static void partitionHelper(int index, String s, List<String> curr,List<List<String>> ans){
        if(index==s.length()){
            ans.add(new ArrayList<>(curr));
            return ;
        }

        //check the valid index for partitioning
        for(int i= index;i<s.length();i++){
            if(isPalindrome(s,index,i)){
                curr.add(s.substring(index, i+1));
                partitionHelper(i+1, s, curr, ans);
                //backtrack
                curr.remove(curr.size()-1);
            }
        }
    }

    public static boolean isPalindrome(String s, int start, int end) {
        while(start<=end){
            if(s.charAt(start++) != s.charAt(end--))
            return false;
        }
        return true;
    }
}
