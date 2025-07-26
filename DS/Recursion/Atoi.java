package DS.Recursion;

public class Atoi {
    public static void main(String[] args) {
        String s = "  -42";
        int val = myAtoi_Recursive(s);
        System.out.println(val);
    }

    public static int myAtoi(String s) {
        //skippingg leading zeros 
        //trigger signs
        //convert digits
        //return signed output


        int n = s.length();

        if(n==0)
        return 0;

        final int int_max = Integer.MAX_VALUE;
        final int int_min = Integer.MIN_VALUE;

        int idx = 0;


        while(idx<n && s.charAt(idx)==' ')
        idx++;


        if(idx==n)
        return 0;


        int sign = 1;

        if(s.charAt(idx)=='-'){
            sign=-1;
            idx++;
        }else if(s.charAt(idx)=='+'){
            idx++;
        }

        long res = 0;

        while(idx < n && Character.isDigit(s.charAt(idx))){

            int digit = s.charAt(idx) - '0';
            res = res*10+ digit;


            if(sign*res <= int_min)
            return int_min;

            if(sign*res >= int_max)
            return int_max;

            idx++;

        } 

        return (int)(res*sign);
    }

        public static int myAtoi_Recursive(String s) {
        if (s == null || s.length() == 0) return 0;

        // Trim leading spaces
        int idx = 0;
        int n = s.length();
        while (idx < n && s.charAt(idx) == ' ') idx++;

        // End of string after trimming
        if (idx == n) return 0;

        // Sign handling
        int sign = 1;
        if (s.charAt(idx) == '-') {
            sign = -1;
            idx++;
        } else if (s.charAt(idx) == '+') {
            idx++;
        }

        // Start recursion
        return recursiveParse(s, idx, 0L, sign);
    }

    private static int recursiveParse(String s, int idx, long res, int sign) {
        if (idx >= s.length() || !Character.isDigit(s.charAt(idx))) {
            return (int)(res * sign);
        }

        int digit = s.charAt(idx) - '0';
        res = res * 10 + digit;

        // Overflow check
        if (sign * res <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
        if (sign * res >= Integer.MAX_VALUE) return Integer.MAX_VALUE;

        return recursiveParse(s, idx + 1, res, sign);
    }
}
