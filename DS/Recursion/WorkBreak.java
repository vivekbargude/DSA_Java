package DS.Recursion;

import java.util.*;

// Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

// Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

// Example 1:

// Input: s = "leetcode", wordDict = ["leet","code"]
// Output: true
// Explanation: Return true because "leetcode" can be segmented as "leet code".
// Example 2:

// Input: s = "applepenapple", wordDict = ["apple","pen"]
// Output: true
// Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
// Note that you are allowed to reuse a dictionary word.
// Example 3:

// Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
// Output: false
 

// Constraints:

// 1 <= s.length <= 300
// 1 <= wordDict.length <= 1000
// 1 <= wordDict[i].length <= 20
// s and wordDict[i] consist of only lowercase English letters.
// All the strings of wordDict are unique.

public class WorkBreak {

    private Boolean[] t;
    int n;

    public boolean wordBreak(String s, List<String> wordDict) {
        n = s.length();
        Set<String> dict = new HashSet<>(wordDict);
        t = new Boolean[n];
        return dfs(0, s, dict);
    }

    private boolean dfs(int start, String s, Set<String> dict) {
        if(start==n){
            return true;
        }

        if(t[start] != null)
        return t[start];

        for(int end = start + 1; end <= n ; end++) {
            String substr = s.substring(start,end);
            if(dict.contains(substr) && dfs(end, s, dict)){
                return t[start] = true;
            }
        }

        return t[start] = false;
    }
}
