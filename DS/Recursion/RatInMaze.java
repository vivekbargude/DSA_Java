package DS.Recursion;
import java.util.*;

public class RatInMaze {
    public static void main(String[] args) {
        int[][] maze = {{1,0,0,0},{1,1,0,1},{1,1,0,0},{0,1,1,1}};
        int n = maze.length;
        int[][] visited = new int[n][n];
        List<String> ans = new ArrayList<>();

        if(maze[0][0] == 1)
        dfs(0, 0, n, maze, visited, "", ans);

        for (int i = 0; i < ans.size(); i++)
        System.out.println(ans.get(i));
        

    } 

    static void dfs(int i, int j, int n, int[][] maze, int[][] visited, String curr, List<String> ans){
        //reached the goal base condition
        if( i == n-1 && j == n-1){
            ans.add(curr);
            return;
        }

        //try down
        if( i+1 < n && visited[i+1][j] != 1 && maze[i+1][j] == 1 ){
            visited[i+1][j]=1; //mark
            dfs(i+1, j, n, maze, visited, curr + "D", ans); //explore
            visited[i+1][j]=0; //unmark
        }

        //try left
        if( j-1 >= 0 && visited[i][j-1] != 1 && maze[i][j-1] == 1){
            visited[i][j-1] = 1; //mark
            dfs(i, j-1, n, maze, visited, curr + "L", ans); //explore
            visited[i][j-1] = 0; //unmark
        }

        //try right
        if( j+1 < n && visited[i][j+1] != 1 && maze[i][j+1] == 1){
            visited[i][j+1] = 1; //mark
            dfs(i, j+1, n, maze, visited, curr + "R", ans); //explore
            visited[i][j+1] = 0;
        }

        //try up
        if( i-1 >= 0 && visited[i-1][j] != 1 && maze[i-1][j] == 1){
            visited[i-1][j] = 1; //mark
            dfs(i-1, j, n, maze, visited, curr + "U", ans);
            visited[i-1][j] = 0;
        }
    }
}
