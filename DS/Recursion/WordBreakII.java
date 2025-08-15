package DS.Recursion;

// Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.

// Note that the same word in the dictionary may be reused multiple times in the segmentation.

// Example 1:

// Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
// Output: ["cats and dog","cat sand dog"]
// Example 2:

// Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
// Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
// Explanation: Note that you are allowed to reuse a dictionary word.
// Example 3:

// Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
// Output: []
 

// Constraints:

// 1 <= s.length <= 20
// 1 <= wordDict.length <= 1000
// 1 <= wordDict[i].length <= 10
// s and wordDict[i] consist of only lowercase English letters.
// All the strings of wordDict are unique.
// Input is generated in a way that the length of the answer doesn't exceed 105.

import java.util.*;

public class WordBreakII {

    public static void main(String[] args) {
        List<String> ans = wordBreak("catsanddog",Arrays.asList("cat","cats","and","sand","dog"));
        System.out.println(ans);
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordDict);

        dfs(0, s, dict, new StringBuilder(), ans);
        return ans;
    }

    public static void dfs(int start, String s, Set<String> dict, StringBuilder sb, List<String> ans) {
        if(start==s.length()){
            ans.add(sb.toString());
            return;
        }

        for(int end = start+1; end<=s.length(); end++){
            String sub = s.substring(start,end);

            if(dict.contains(sub)){
                int len = sb.length();
                sb.append(sub);
                if(end!=s.length())
                sb.append(" ");
                //System.out.println(sb);
                dfs(end, s, dict, sb, ans);
                sb.setLength(len);
                //System.out.println(sb);
            }
        }
    }
}

//Approach-2 (Using simple backtracking)
//T.C : O(2^n)
//S.C : max depth of recursion is n (length of string s). You can say O(n) . You also have to store those sentences which is O(2^n)
class Solution {
    private Set<String> dict;
    private Map<String, List<String>> memo;

    private List<String> solve(String s) {
        if (s.isEmpty()) {
            return Arrays.asList("");
        }
        
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        List<String> result = new ArrayList<>();
        for (int l = 1; l <= s.length(); l++) {
            String currWord = s.substring(0, l);
            if (dict.contains(currWord)) {
                String remainWord = s.substring(l);
                List<String> remainResult = solve(remainWord);
                for (String w : remainResult) {
                    String toAdd = currWord + (w.isEmpty() ? "" : " ") + w;
                    result.add(toAdd);
                }
            }
        }

        memo.put(s, result);
        return result;
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        dict = new HashSet<>(wordDict);
        memo = new HashMap<>();

        return solve(s);
    }
}
