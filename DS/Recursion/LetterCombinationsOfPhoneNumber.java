package DS.Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

// A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


// Example 1:

// Input: digits = "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// Example 2:

// Input: digits = ""
// Output: []
// Example 3:

// Input: digits = "2"
// Output: ["a","b","c"]
 

// Constraints:

// 0 <= digits.length <= 4
// digits[i] is a digit in the range ['2', '9'].

public class LetterCombinationsOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length()==0){
            return ans;
        }

        Map<Character,String> map = new HashMap<>();
        createHashMap(map);

        helper(map,0,digits, new StringBuilder(),ans);

        return ans;
    }

    static void createHashMap(Map<Character,String> map){
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
    }

    static void helper(Map<Character,String> map,int index, String s,StringBuilder curr,List<String> ans){
        if(index==s.length()){
            ans.add(curr.toString());
            return;
        }

        String currString = map.get(s.charAt(index));

        for(int i=0;i<currString.length();i++){
            curr.append(currString.charAt(i));
            helper(map,index+1,s,curr,ans);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}

/*
Input digits = "23"
Output = ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Expected = ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */
