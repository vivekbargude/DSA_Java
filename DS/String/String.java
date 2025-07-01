package DS.String;

class StringP {
    public static void main(String[] args) {
        
    }

    //3330. Find the Original Typed String I
    // Input: word = "abbcccc"
    // Output: 5
    // Explanation:
    // The possible strings are: "abbcccc", "abbccc", "abbcc", "abbc", and "abcccc".

    public static int possibleStringCount(String word) {
        int n=word.length();
        int count=n;
        for(int i=1;i<word.length();i++){
            if(word.charAt(i)!=word.charAt(i-1)){
                count--;
            }
        }
        return count;
    }
}
