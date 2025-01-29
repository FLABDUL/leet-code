package problems.graph_general.numer_of_islands;

public class NumberOfIslandsLog {
    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        NumberOfIslandsLog numberOfIslandsSolution = new NumberOfIslandsLog();
        System.out.println("Result: " + numberOfIslandsSolution.numIslands(grid));
    }

    private int n; // Number of rows in the grid
    private int m; // Number of columns in the grid

    /**
     * Uses Depth-First Search (DFS) to count the number of islands in a given grid.
     *
     * Time Complexity: O(N * M), where N is the number of rows and M is the number of columns.
     * Each cell is visited once and marked.
     *
     * Space Complexity: O(N * M) in the worst case due to recursive call stack (when all are '1').
     * In the best case (few islands), the stack depth remains low.
     *
     * Pros:
     * - Simple and easy to understand implementation.
     * - Modifies the grid in place, avoiding extra space for visited cells.
     *
     * Cons:
     * - Uses recursion, which might cause stack overflow on large inputs.
     * - Modifies the input grid, which might not be desirable in some cases.
     *
     * Uses:
     * - Connected component detection in grid-based problems.
     * - Flood fill algorithm.
     */
    public int numIslands(char[][] grid) {
        int count = 0;
        n = grid.length;
        if (n == 0) return 0;
        m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    System.out.println("Found island at: (" + i + ", " + j + ")");
                    DFSMarking(grid, i, j);
                    ++count;
                    System.out.println("Island count incremented to: " + count);
                }
            }
        }
        return count;
    }

    /**
     * Marks the current island region using DFS.
     *
     * This is a classic DFS-based flood fill algorithm to traverse connected '1's.
     */
    private void DFSMarking(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') {
            System.out.println("Skipping: (" + i + ", " + j + ")");
            return;
        }

        System.out.println("Marking visited at: (" + i + ", " + j + ")");
        grid[i][j] = '0'; // Mark as visited

        // Recursively visit all connected land cells
        DFSMarking(grid, i + 1, j);
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i, j + 1);
        DFSMarking(grid, i, j - 1);
    }
}
