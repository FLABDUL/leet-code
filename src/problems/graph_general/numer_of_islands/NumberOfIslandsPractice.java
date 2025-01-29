package problems.graph_general.numer_of_islands;

public class NumberOfIslandsPractice {
    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        NumberOfIslandsPractice numberOfIslandsPractice = new NumberOfIslandsPractice();
        System.out.println("result: " + numberOfIslandsPractice.numIslands(grid));
    }
    private int n;
    private int m;

    public int numIslands(char[][] grid) {
        int count = 0;
        n = grid.length;//y
        if (n == 0) return 0;
        m = grid[0].length;//x
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    marking(grid, i, j);
                    ++count;
                }
            }
        }
        return count;
    }

    private void marking(char[][] grid, int i, int j) {
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j] != '1') return;
        grid[i][j]='0';
        marking(grid,i+1, j);
        marking(grid,i-1, j);
        marking(grid,i, j+1);
        marking(grid,i, j-1);
    }
}
