package DS.Recursion;

public class SudukoSolver {
    public static void main(String[] args) {
        //solve(null)
    }

    public static boolean solve(char[][] board){
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i<m; i++){
            for(int j=0; j<n; j++){
                //check if it empty then try to fill
                if(board[i][j] == '.'){

                    //try each number at that empty place 
                    for(char c='1';c<='9';c++){

                        //check for valid case only
                        if(isValid(board,i,j,c)){
                            //put the number there and go forward
                            board[i][j]=c;
                            //if solved then returned true
                            if(solve(board))
                            return true;
                            //else not solved got stucked then backtrack
                            else 
                            board[i][j]='.';
                        }
                    }
                    //all number check but not possible
                    return false;
                }
            }
        }
        //if no empty found -> game is solved
        return true;
    }

    private static boolean isValid(char[][] board, int row, int col, char c) {
        int n = board.length;
        for(int i=0;i<n;i++){

            //checking for row case
            if(board[row][i] == c)
            return false;

            //checking for the column case
            if(board[i][col] == c)
            return false;

            //checking for the matrix
            if(board[ 3 * (row/3) + i/3][3 * (col/3) + i%3] == c)
            return false;
        }

        return true;
    }
}
