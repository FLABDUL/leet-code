package problems.rotateimage;

import java.util.Arrays;

public class RotateImageLogs {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        RotateImageLogs rotateImageLogs = new RotateImageLogs();
        rotateImageLogs.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));

    }

    public void rotate(int[][] matrix) {
        System.out.println("Starting matrix rotation...");

        // Step 1: Transpose the matrix (swap rows with columns)
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                // Logging the transpose process
                System.out.println("Swapping matrix[" + i + "][" + j + "] with matrix[" + j + "][" + i + "]");
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        System.out.println("Matrix after transpose:");
        printMatrix(matrix);

        // Step 2: Reverse each row
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                // Logging the row reversal process
                System.out.println("Reversing row " + i + ": swapping matrix[" + i + "][" + j + "] with matrix[" + i + "][" + (matrix.length - 1 - j) + "]");
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
        System.out.println("Matrix after rotation:");
        printMatrix(matrix);
    }

    // Helper method to print the matrix for better visualization
    private void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

/*
Uses:
- This method rotates an `n x n` matrix 90 degrees clockwise in place.
- Commonly used in computer graphics, image manipulation, or puzzle-solving.

Pros:
1. Efficient:
   - Operates in O(n^2) time since it processes every element in the matrix exactly twice.
   - In-place rotation means no additional space is required (space complexity is O(1)).
2. Clear steps:
   - The logic is broken into two intuitive steps: transpose and row reversal.

Cons:
1. Limited to square matrices:
   - The algorithm assumes the input matrix is always square (`n x n`).
   - Does not work for non-square matrices or rectangular grids.
2. Lack of input validation:
   - The code assumes the input is valid (e.g., no null checks, no validation for empty arrays).
3. Verbosity in large matrices:
   - For very large matrices, this approach may produce excessive logs.

Behavior Logs:
- Logs every swap during transposition and reversal.
- Prints intermediate matrix states for better understanding of each step.
- Helps identify potential bugs in specific swaps.
*/

