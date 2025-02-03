package problems.graph_general.surrounding_regions;

import java.util.Arrays;
//neetcode https://www.youtube.com/watch?v=9z2BunfoZ5Y
public class SurroundingRegionsLogger {
    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        System.out.println("Initial board: " + Arrays.deepToString(board));

        SurroundingRegionsLogger solution = new SurroundingRegionsLogger();
        solution.solve(board);

        System.out.println("Final board: " + Arrays.deepToString(board));
    }

    /**
     * Solves the "Surrounded Regions" problem by modifying the board in place.
     * Uses Depth-First Search (DFS) to mark safe 'O' cells and then flips the remaining 'O' cells.
     *
     * Time Complexity: O(m * n) -> Each cell is visited at most once.
     * Space Complexity: O(m * n) in worst case due to recursive DFS call stack.
     *
     * Pros:
     * - Modifies the board in place, saving extra space.
     * - Simple and easy to understand approach.
     *
     * Cons:
     * - Recursive DFS might cause stack overflow for large boards.
     * - Can be optimized using an iterative BFS approach with a queue.
     *
     * Uses: Graph traversal algorithm (DFS) to solve the problem.
     */
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        int m = board.length;
        int n = board[0].length;

        System.out.println("Starting DFS on border 'O's...");
        // Go through the first and last columns
        for (int i = 0; i < m; i++) {//not needed to use dfs why why not
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }

        // Go through the first and last rows
        for (int j = 1; j < n - 1; j++) {
            dfs(board, 0, j);
            dfs(board, m - 1, j);
        }

        System.out.println("After marking safe 'O's: " + Arrays.deepToString(board));

        // Convert remaining 'O' to 'X' and '*' back to 'O'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    System.out.println("Flipping ('O' -> 'X') at position (" + i + ", " + j + ")");
                    board[i][j] = 'X';
                }
                if (board[i][j] == '*') {
                    System.out.println("Restoring ('*' -> 'O') at position (" + i + ", " + j + ")");
                    board[i][j] = 'O';
                }
            }
        }
    }

    /**
     * Depth-First Search (DFS) to mark all connected 'O' cells starting from border.
     * Marks visited 'O' cells as '*', indicating they should not be flipped.
     */
    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        if (board[i][j] == 'X' || board[i][j] == '*') return;

        System.out.println("Marking ('O' -> '*') at position (" + i + ", " + j + ")");
        board[i][j] = '*';

        // Recursive DFS calls for all four directions
        dfs(board, i - 1, j); // Up
        dfs(board, i + 1, j); // Down
        dfs(board, i, j - 1); // Left
        dfs(board, i, j + 1); // Right
    }
}
