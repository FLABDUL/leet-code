package problems.graph_general.surrounding_regions;

import java.util.Arrays;

public class SurroundingRegionsPractice {
    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        System.out.println("Initial board: " + Arrays.deepToString(board));

        SurroundingRegionsPractice solution = new SurroundingRegionsPractice();
        solution.solve(board);

        System.out.println("Final board: " + Arrays.deepToString(board));
    }

    private void solve(char[][] board) {
        if(board.length==0 || board[0].length==0){
            return;
        }

        int y = board.length;
        int x = board[0].length;

        for(int i=0; i < y; i++){//all y axis
            dfs(board, i, 0);//first column
            dfs(board, i, x-1);//last column
        }

        for(int j=1; j < x-1; j++){//all x axis
            dfs(board, 0, j);//first row
            dfs(board, y-1, j);//last row
        }

        for(int i=0; i<y; i++){
            for(int j=0; j<x; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == '*'){
                    board[i][j] = 'O';
                }
            }
        }

    }

    private void dfs(char[][] board, int i, int j) {
        if(i <0 || i>=board.length || j<0 || j>= board[0].length){
            return;
        }
        if(board[i][j] == 'X' || board[i][j] == '*'){
            return;
        }

        board[i][j] = '*';//if not X or *, so O

        dfs(board, i-1, j);
        dfs(board, i+1, j);
        dfs(board, i, j-1);
        dfs(board, i, j+1);
    }

}
