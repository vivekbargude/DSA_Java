package DS.Recursion;

// Given an m x n grid of characters board and a string word, return true if word exists in the grid.

// The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

// Example 1:


// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
// Output: true
// Example 2:


// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
// Output: true
// Example 3:


// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
// Output: false
 

// Constraints:

// m == board.length
// n = board[i].length
// 1 <= m, n <= 6
// 1 <= word.length <= 15
// board and word consists of only lowercase and uppercase English letters.
 

public class WordSearch {
    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;
        
        for(int i = 0; i<m ; i++){
            for(int j = 0; j<n ; j++){
                    if(dfs(i,j,m,n,board,0,word))
                    return true;
            }
        }
        return false;
    }

    static boolean dfs(int i, int j, int m, int n, char[][] board, int idx, String word){
        //check we have reached till the end that means we got the word
        if(idx==word.length()){
            return true;
        }

        //check if we are going out of bound
        if(i<0 || j<0 || i==m || j==n)
        return false;

        //check if the current character doesnt matched with character at i,j
        if(board[i][j] != word.charAt(idx))
        return false;

        //mark the path
        char ch = board[i][j];
        board[i][j] = '.';

        //explore all and check if any path exists
        if(
            dfs(i,j-1,m,n,board,idx+1,word) || //left 
            dfs(i,j+1,m,n,board,idx+1,word) || //right
            dfs(i-1,j,m,n,board,idx+1,word) || //up
            dfs(i+1,j,m,n,board,idx+1,word) //down
        ) {
            return true; //if got any path
        }

        board[i][j] = ch; //backtrack
        
        return false; //no path found
        
    }
}
