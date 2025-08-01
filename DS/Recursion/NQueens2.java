package DS.Recursion;

import java.util.*;

//optimized n-queens using hashing

public class NQueens2 {
    public static void main(String[] args) {
        List<List<String>> res = new ArrayList<>();

        res = solveNQueens(4);

        for(List<String> list : res){
            for(String s : list){
                System.out.print(s+" ");
            }
            System.out.println();
        }
    }

    public static List < List < String >> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        List < List < String >> res = new ArrayList < List < String >> ();
        int leftRow[] = new int[n];
        int upperDiagonal[] = new int[2 * n - 1];
        int lowerDiagonal[] = new int[2 * n - 1];
        dfs(0,n, board, res,leftRow,upperDiagonal,lowerDiagonal);
        return res;
    }

    public static void dfs(int col, int n, char[][] board, List<List<String>> ans, int[] leftRow, int[] upperDiagonal, int[] lowerDiagonal){   
        if(col>=n){
            ans.add(construct(board));
            return;
        }

        for(int row = 0;row<n;row++){
            if(leftRow[row] == 0 && upperDiagonal[row+col] == 0 && lowerDiagonal[(n-1) + (col-row)] == 0 ){
                //try this case
                leftRow[row] = 1;
                upperDiagonal[row+col] = 1;
                lowerDiagonal[(n-1) + (col-row)] = 1;
                board[row][col] = 'Q';
                dfs(col+1, n, board, ans, leftRow, upperDiagonal, lowerDiagonal);


                //backtrack
                board[row][col] = '.';
                leftRow[row] = 0;
                upperDiagonal[row+col] = 0;
                lowerDiagonal[(n-1) + (col-row)] = 0;

            }
        }


    }

    public static boolean isSafe(int row, int col, char[][] board, int n) {
        int dupRow = row;
        int dupCol = col;

        //check for top going diagonal
        while(row>=0 && col>=0){
            if(board[row][col]=='Q')
            return false;

            row--;
            col--;
        }

        row = dupRow;
        col = dupCol;

        //check for the same left row whether
        while(col>=0){
            if(board[row][col]=='Q')
            return false;

            col--;
        }

        row=dupRow;
        col=dupCol;

        //check for the lower left going diagonal
        while(row<n && col>=0){
            if(board[row][col]=='Q')
            return false;

            row++;
            col--;
        }

        return true; //safe condition
    }

    public static List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        int n = board.length;
        for(int i=0; i<n;i++){
            //construct the string for each row by converting that row of char[] into string
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}
