package DS.Array;

// Segregate 0s and 1s in an array
// Last Updated : 09 Jul, 2025
// You are given an array of 0s and 1s in random order. Segregate 0s on left side and 1s on right side of the array [Basically you have to sort the array]. Traverse array only once. 

// Input :  [0, 1, 0, 1, 0, 0, 1, 1, 1, 0] 
// Output :  [0, 0, 0, 0, 0, 1, 1, 1, 1, 1] 

// Input :  [0, 1, 0]  
// Output :  [0, 0, 1] 

// Input :  [1, 1]  
// Output :  [1, 1] 

// Input :  [0]  
// Output :  [0] 


public class July22{
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0 };
        arr = seggregate_01(arr);
        for(int num : arr){
            System.out.println(num + " ");
        }
    }

    public static int[] seggregate_01(int[] arr){
        int n = arr.length;

        int i=0,j=n-1,m=0;
        
        while(i<=j && m<n){
            if(arr[m]==0){
                arr[i++]=0;
                m++;
            }else{
                arr[j--]=1;
                m++;
            }
        }

        return arr;
    }
}