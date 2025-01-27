package problems.validsudoku;

import java.util.HashSet;
import java.util.Set;

public class ValidSudokuLogger {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        ValidSudokuLogger validSudokuLogger = new ValidSudokuLogger();
        System.out.println("result: " + validSudokuLogger.isValidSudoku(board));

    }

    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>(); // A set to track unique constraints
        System.out.println("Starting validation..."); // Log the start of validation

        for (int i = 0; i < 9; ++i) { // Iterate through each row
            for (int j = 0; j < 9; ++j) { // Iterate through each column
                char number = board[i][j];

                if (number != '.') { // Skip empty cells
                    // Log the current number being processed
                    System.out.println("Processing number '" + number + "' at position [" + i + "][" + j + "]");

                    // Check row constraint
                    boolean rowAdded = seen.add(number + " in row " + i);
                    if (!rowAdded) {
                        System.out.println("Duplicate found in row: '" + number + "' at row " + i);
                        return false;
                    }

                    // Check column constraint
                    boolean colAdded = seen.add(number + " in column " + j);
                    if (!colAdded) {
                        System.out.println("Duplicate found in column: '" + number + "' at column " + j);
                        return false;
                    }

                    // Check block constraint
                    boolean blockAdded = seen.add(number + " in block " + i / 3 + "-" + j / 3);
                    if (!blockAdded) {
                        System.out.println("Duplicate found in block: '" + number + "' in block " + i / 3 + "-" + j / 3);
                        return false;
                    }
                }
            }
        }

        System.out.println("Validation complete. The board is valid.");
        return true; // All constraints satisfied, the board is valid
    }

/*
Uses:
- Validates if a given Sudoku board follows the Sudoku rules.
- Can be used in solving Sudoku puzzles or verifying partially filled boards.

Pros:
1. Efficient:
   - Uses a single `Set` to track constraints for rows, columns, and blocks.
   - Each number is checked in constant time (O(1) for `HashSet` operations).
   - Overall complexity is O(81) or O(1) for a fixed 9x9 board.
2. Clear logic:
   - Separates checks for rows, columns, and blocks into distinct conditions.
3. Adaptable:
   - Can easily adjust for boards of different sizes or additional constraints.

Cons:
1. Limited to 9x9 boards:
   - Assumes fixed constraints for a standard Sudoku board.
   - Needs modification for non-standard Sudoku sizes.
2. Debugging:
   - Errors like incorrect `i / 3` calculations for blocks may not be apparent without proper testing.
3. Memory overhead:
   - Uses a `HashSet` to store strings, which adds some memory usage.
   - Could be optimized further using integer-based encodings.

Behavior Logs:
- Logs demonstrate the current number and its position.
- Indicates where duplicates are found, helping debug invalid boards.
*/

}
