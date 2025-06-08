// Given two sorted arrays nums1 and nums2, return an array that contains the union of these two arrays. The elements in the union must be in ascending order.



// The union of two arrays is an array where all values are distinct and are present in either the first array, the second array, or both.


// Examples:
// Input: nums1 = [1, 2, 3, 4, 5], nums2 = [1, 2, 7]

// Output: [1, 2, 3, 4, 5, 7]

// Explanation: The elements 1, 2 are common to both, 3, 4, 5 are from nums1 and 7 is from nums2

// Input: nums1 = [3, 4, 6, 7, 9, 9], nums2 = [1, 5, 7, 8, 8]

// Output: [1, 3, 4, 5, 6, 7, 8, 9]

// Explanation: The element 7 is common to both, 3, 4, 6, 9 are from nums1 and 1, 5, 8 is from nums2

import java.util.ArrayList;

public class union_array{
public static void main(String[] args) {
    // int[] a = {1,2,3,4,5};
    //     int[] b = {1,2,7};

    //     int[] result = unionArray(a, b);

    //     for (int num : result) {
    //         System.out.print(num + " ");
    //     }
}

public int[] unionArray(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int i = 0;
        int j = 0;
        ArrayList<Integer> union_arr = new ArrayList<Integer>();

        while (i<n1 && j<n2){
            if(nums1[i]<=nums2[j]){
                if(union_arr.size()==0 || union_arr.contains(nums1[i]) == false){
                    union_arr.add(nums1[i]);
                }
                i++;
            }else{
                if(union_arr.size()==0 || union_arr.contains(nums2[j]) == false){
                    union_arr.add(nums2[j]);
                }
                j++;
            }
        }

        while(i<n1){
            if(union_arr.size()==0 || union_arr.contains(nums1[i]) == false){
                union_arr.add(nums1[i]);
            }
            i++;
        }

        while(j<n2){
            if(union_arr.size()==0 || union_arr.contains(nums1[i]) == false){
                union_arr.add(nums1[i]);
            }
            i++;
        }
        int size = union_arr.size();
        int ans[] = new int[size];
        for(int k=0; k<size;k++){
            ans[k]=union_arr.get(k);
        }

        return ans;
        
    }
}


