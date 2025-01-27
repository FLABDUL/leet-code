package problems.spiralmatrix;

import java.util.LinkedList;
import java.util.List;

class SpiralMatrixLogs {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        SpiralMatrixLogs spiralMatrixLogs = new SpiralMatrixLogs();
        System.out.println("result: " + spiralMatrixLogs.spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();

        // Log the start of the method
        System.out.println("Starting spiralOrder method...");

        if (matrix == null || matrix.length == 0) {
            System.out.println("Input matrix is empty or null. Returning an empty list.");
            return res;
        }

        int n = matrix.length, m = matrix[0].length;
        int up = 0, down = n - 1;
        int left = 0, right = m - 1;

        System.out.println("Matrix dimensions: " + n + " rows, " + m + " columns.");
        System.out.println("Initial bounds -> up: " + up + ", down: " + down + ", left: " + left + ", right: " + right);

        while (res.size() < n * m) {
            // Traverse from left to right on the top row
            for (int j = left; j <= right && res.size() < n * m; j++) {
                res.add(matrix[up][j]);
                System.out.println("Added " + matrix[up][j] + " from top row, position [" + up + "][" + j + "]");
            }

            // Traverse from top to bottom on the right column
            for (int i = up + 1; i <= down - 1 && res.size() < n * m; i++) {
                res.add(matrix[i][right]);
                System.out.println("Added " + matrix[i][right] + " from right column, position [" + i + "][" + right + "]");
            }

            // Traverse from right to left on the bottom row
            for (int j = right; j >= left && res.size() < n * m; j--) {
                res.add(matrix[down][j]);
                System.out.println("Added " + matrix[down][j] + " from bottom row, position [" + down + "][" + j + "]");
            }

            // Traverse from bottom to top on the left column
            for (int i = down - 1; i >= up + 1 && res.size() < n * m; i--) {
                res.add(matrix[i][left]);
                System.out.println("Added " + matrix[i][left] + " from left column, position [" + i + "][" + left + "]");
            }

            // Shrink the bounds after completing a layer
            left++;
            right--;
            up++;
            down--;
            System.out.println("Updated bounds -> up: " + up + ", down: " + down + ", left: " + left + ", right: " + right);
        }

        System.out.println("Spiral order traversal complete. Result: " + res);
        return res;
    }
}

/*
Uses:
- This method extracts elements of a matrix in a spiral order, which is a common problem in 2D array manipulations.
- Useful in scenarios where we need to transform 2D data into a linear sequence while preserving spatial patterns (e.g., image processing or rendering).

Pros:
1. Logical and systematic:
   - Iteratively reduces bounds for rows and columns while maintaining order.
2. General-purpose:
   - Works for any rectangular matrix (not just square).
3. Efficient:
   - Traverses each element exactly once (O(n * m) time complexity).

Cons:
1. Verbose structure:
   - The logic is split across multiple `for` loops, which can be harder to follow at a glance.
2. Assumes valid input:
   - No handling for edge cases like null rows/columns or jagged arrays.
3. Memory usage:
   - Uses a `List` to store the result, which doubles memory requirements.

Behavior Logs:
- Logs display the matrix's dimensions, each element added to the result, and updates to bounds after processing a layer.
- Helps debug edge cases like single-row or single-column matrices.

*/
