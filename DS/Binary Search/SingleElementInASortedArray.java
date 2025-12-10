// You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

// Return the single element that appears only once.

// Your solution must run in O(log n) time and O(1) space.

// Example 1:
// Input: nums = [1,1,2,3,3,4,4,8,8]
// Output: 2

// Example 2:
// Input: nums = [3,3,7,7,10,11,11]
// Output: 10
 

// Constraints:

// 1 <= nums.length <= 105
// 0 <= nums[i] <= 105

import java.util.HashMap;
import java.util.Map;

public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        return binarySearch(nums);
    }

    //Approach 1: Brute Force using HashMap.
    //TC -> O(N) + O(N)
    //SC -> O(N)
    public int usingMap(int[] nums){
        Map<Integer,Integer> freq = new HashMap<>();
        int ans = -1;
        for(int num: nums){
            freq.put(num, freq.getOrDefault(num,0)+1);
        }

        for(Integer key : freq.keySet()){
            if(freq.get(key) == 1){
                ans = key;
                break;
            }
        }
        return ans;
    }

    //Approach 2: Better Solution using two pointer.
    //TC -> O(N)
    //SC -> O(1)
    public int usingTwoPointer(int[] nums){
        int ptr1 = 0,ptr2 = 1;
        int n = nums.length;

        if(n==1)
        return nums[0];

        while(ptr1<n){

            if(ptr2==n)
            break;

            if(nums[ptr1]!=nums[ptr2])
            break;

            ptr1+=2;
            ptr2+=2;
        }
        return nums[ptr1];
    }

    //Approach 3: Better Solution using single pointer(checks for elements at right or left).
    //TC -> O(N)
    //SC -> O(1)
    public int usingOnePointer(int[] arr){
        int n = arr.length;

        //Edge case 1: Single element case.
        if(n==1)
        return arr[0];

        for(int i=0;i<n;i++){

            //Edge case 2: Element at 0th index.
            if(i==0){
                if(arr[0]!=arr[1])
                return arr[0];
            }
            //Edge case 3: Element at (n-1)th index.
            else if(i==n-1){
                if(arr[n-1]!=arr[n-2])
                return arr[n-1];
            }
            else{
                if(arr[i]!=arr[i-1] && arr[i]!=arr[i+1])
                return arr[i];
            }
        }

        return -1;
    }    

    //Approach 4 : Optimized using binary search
    //TC -> O(logN)
    //SC -> O(1)
    public int binarySearch(int[] arr){
        int n = arr.length;

        //Edge case 1: Single element case.
        if(n==1)
        return arr[0];

        //Edge case 2: Element at 0th index.
        if(arr[0]!=arr[1])
        return arr[0];

        //Edge case 3: Element at (n-1)th index.
        if(arr[n-1]!=arr[n-2])
        return arr[n-1];

        int low=1,high=n-2;

        while(low<=high){
            int mid = (low + high) / 2;

            //Checking whether element at mid is probable ans or not.
            if(arr[mid]!=arr[mid-1] && arr[mid]!=arr[mid+1])
            return arr[mid];

            //Standing at left half and element is in right half.
            if(
                ( mid%2 == 1 && arr[mid] == arr[mid-1] ) || 
                ( mid%2 == 0 && arr[mid] == arr[mid+1] )
            ){
                //Eliminate the left half.
                low = mid + 1;
            }
            //Standing at right half and element is in left half.
            else{
                //Eliminate the right half.
                high = mid - 1;
            }
        }

        return -1;
    }
}
