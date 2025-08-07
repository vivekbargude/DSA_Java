package DS.Recursion;

import java.util.ArrayList;
import java.util.List;

// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

// Example 1:

// Input: n = 3
// Output: ["((()))","(()())","(())()","()(())","()()()"]
// Example 2:

// Input: n = 1
// Output: ["()"]
 

// Constraints:

// 1 <= n <= 8

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(new StringBuilder(), 0, 0, n, ans);
        return ans;
    }

    static void helper(StringBuilder curr, int open, int close, int n, List<String> ans){

        //base condition
        //note: size will 2 times because each opening bracket will have corresponding closing
        if(curr.length()==2*n){
            ans.add(curr.toString());
            return;
        }


        //check for opening braket 
        //if we have used n brackets so far then we can't use furthur 
        // if not we can use another 

        if( open < n ){
            curr.append('(');
            helper(curr,open+1,close,n,ans);
            curr.deleteCharAt(curr.length()-1); //backtrack
        }

        //if we have more opening brackets then closing then only we can use another closing
        if( close < open ){
            curr.append(')');
            helper(curr,open,close+1,n,ans);
            curr.deleteCharAt(curr.length()-1); //backtrack
        }
    }
}
