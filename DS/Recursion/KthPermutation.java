package DS.Recursion;

import java.util.ArrayList;
import java.util.List;

// The set [1, 2, 3, ..., n] contains a total of n! unique permutations.

// By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

// "123"
// "132"
// "213"
// "231"
// "312"
// "321"
// Given n and k, return the kth permutation sequence.

// Example 1:

// Input: n = 3, k = 3
// Output: "213"
// Example 2:

// Input: n = 4, k = 9
// Output: "2314"
// Example 3:

// Input: n = 3, k = 1
// Output: "123"
 

// Constraints:

// 1 <= n <= 9
// 1 <= k <= n!

public class KthPermutation {
    //Brute force: TC-> O(n!) * O(n) * n! log n!  SC-> O(n)
    // public String getPermutation(int n, int k) {
    //     List<String> ans = new ArrayList<>();
    //     String s = "";

    //     for(int i = 1; i <= n ; i++){
    //         s+=i;
    //     }

    //     permutationHelper(0, s.toCharArray(), ans );
    //     Collections.sort(ans);

    //     return ans.get(k-1);
    // }

    // static void swap(char[] s, int i, int j){
    //     char ch = s[i];
    //     s[i] = s[j];
    //     s[j] = ch;
    // }

    // static void permutationHelper(int idx, char[] s,List<String> ans){
    //     //base condition 
    //     if(idx==s.length){
    //         String res = new String(s);
    //         ans.add(res);
    //         return;
    //     }


    //     //try all choice by swapping it with the first element
    //     for(int i= idx; i< s.length; i++){
    //         swap(s, i, idx); //give chance
    //         permutationHelper(idx+1, s, ans); //explore
    //         swap(s, i, idx); //backtrack
    //     }
    // }


    public String getPermutation(int n, int k) {
        
        //for storing the actual ans
        List<Integer> numbers = new ArrayList<>();

        //get the initial factorial 
        int fact = 1;
        for(int i=1; i<n; i++){
            fact = fact * i;
            numbers.add(i);
        }
        numbers.add(n);


        //for returning ans
        String ans = "";
        //converting the k to 0 based indexing 
        k = k-1;

        //start breaking the range into smaller range 
        while(true){
            //add the number to ans
            ans = ans + numbers.get(k/fact);
            //remove it from the choices
            numbers.remove(k/fact);

            if(numbers.size()==0){
                break; //case of array got exhausted then stop
            }

            //get the new value of k 
            k = k % fact;
            //get the new value of factorial by dividing the old one by numbers.size()
            fact = fact / numbers.size();
        }

        return ans;
    }
}
