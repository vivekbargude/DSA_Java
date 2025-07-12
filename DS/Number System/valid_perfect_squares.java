class Solution {
    public boolean isPerfectSquare(int num) {
        int low = 1,high = num;

        while(low<=high){
            int mid = low+(high-low)/2;
            long  mid_square =(long) mid*mid;
            if(mid_square==num)
            return true;

            else if(mid_square<num)
            low=mid+1;

            else 
            high = mid-1;
        }

        return false;
    }
}