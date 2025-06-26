package DS.BitManipulation;

//Functions:
//1. No of 1 bits(set bits)
//2. Check whether the number is power of two or not


 class bitmanipulation {
        public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (((n >> i) & 1) == 1) {
                res += 1;
            }
        }
        return res;        
    }

    public boolean isPowerOfTwo(int n) {
        if(n==0) return false;
        while(n%2==0) n/=2;
        return n==1;
    }
    public static void main(String[] args) {
        
    }
    
}
