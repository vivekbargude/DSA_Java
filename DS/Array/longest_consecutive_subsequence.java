// Approaches : 
// Brute Force : Take each element and perform linear search in array for next consecutive sequence TC-> N*N SC-> constant

// Better Approach : Sort the array + chcek for the consecutive sequence TC-> NlogN SC-> constant

// public static int longest_consecutive_subsequence(int[] nums){

//        Arrays.sort(nums);
//         int n = nums.length;
//         int length =0;
//         int maxLength = 0;
//         for(int i=0;i<n-1;i++){
//             if(nums[i+1]==(nums[i]+1))
//             length++;
//             else if (nums[i+1] == nums[i]) continue;
//             else{
//                 if(length>maxLength)
//                 maxLength=length;
//             length=0;
//             }
            
//         }

//         return maxLength+1;

//     }

//Optimal Approach :  

// public static int longest_consecutive_subsequence(int[] nums){

//               int n = nums.length;
//         Set<Integer> st = new HashSet<>();
//         int longest = 1;
//         for(int num : nums)
//         st.add(num);

//         if(n==0){
//             return 0;
//         }

//         for(int it : st){
//             if(!st.contains(it-1)){
//                 int count = 1;
//                 int x = it;
//                 while(st.contains(x+1)){
//                     count+=1;
//                     x+=1;
//                 }
//                 longest = Math.max(longest,count);
//             }
//         }
//         return longest;

//     }

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Main{
    public static void main(String[] args) {
        int arr[] = {0,3,7,2,5,8,4,6,0,1};
        int length = longest_consecutive_subsequence(arr);
        System.out.println(length);
    }

    public static int longest_consecutive_subsequence(int[] nums){

              int n = nums.length;
        Set<Integer> st = new HashSet<>();
        int longest = 1;
        for(int num : nums)
        st.add(num);

        if(n==0){
            return 0;
        }

        for(int it : st){
            if(!st.contains(it-1)){
                int count = 1;
                int x = it;
                while(st.contains(x+1)){
                    count+=1;
                    x+=1;
                }
                longest = Math.max(longest,count);
            }
        }
        return longest;

    }
}
