// You are given an m x n integer matrix matrix with the following two properties:

// Each row is sorted in non-decreasing order.
// The first integer of each row is greater than the last integer of the previous row.
// Given an integer target, return true if target is in matrix or false otherwise.

// You must write a solution in O(log(m * n)) time complexity.

 

// Example 1:


// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
// Output: true
// Example 2:


// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
// Output: false
 

// Constraints:

// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 100
// -104 <= matrix[i][j], target <= 104


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return binarySearchOptimal(matrix,target);
    }

    //Approach 1: Brute Force Solution
    //TC -> O(M*N)
    //SC -> O(1)
    public boolean linearSearch(int[][] matrix, int target) {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==target)
                return true;
            }
        }
        return false;
    }

    //Approach 2: Better solution using row-wise binary search eliminating to traverse each row linearly.
    //TC -> O(MlogN)
    //SC -> O(1)
    public boolean rowWiseBinarySearch(int[][] matrix, int target){
        boolean found=false;
        for(int []row:matrix)if(binarySearech(row,target)){
            found=true;
            break;
        }
        return found;
    }

    public boolean binarySearech(int[]arr,int target){
        int start=0,end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                return true;
            }
            if(arr[mid]>target)end=mid-1;
            else start=mid+1;
        }
        return false;
    }

    //Approach 3: Optimal Approach by flatenning 2D matrix to 1D matrix[0..(n*m)].
    //TC -> O(log(M*N))
    //SC -> O(1)
    public boolean binarySearchOptimal(int[][] matrix, int target){
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0, high = (m*n) - 1;

        while(low <= high){

            int mid = low + (high-low)/2;

            //Mapping 1D index to 2D co-ordinates
            int row = mid / m;
            int col = mid % m;

            if(matrix[row][col]==target)
            return true;
            else if(matrix[row][col]<target)
            low = mid + 1;
            else 
            high = mid - 1;
        }

        return false;
    }
}