//package problems.java.validsudoku;
//
//import java.util.HashSet;
//import java.util.List;
//
//public class ValidSudokuAttempt {
//    public static void main(String[] args) {
//        char[][] board = {
//                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
//                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
//                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
//                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
//        };
//        ValidSudokuAttempt validSudokuAttempt = new ValidSudokuAttempt();
//        System.out.println("result: " + validSudokuAttempt.isValidSudoku(board));
//
//    }
//
//    public boolean isValidSudoku(char[][] board) {
//        HashSet<Integer> validNumbers = new HashSet<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
//        for(char[] row : board){
//            for(char value : row){
//                System.out.println("value: " + value);
//                if(validNumbers.contains(Integer.parseInt(String.valueOf(value))){
//                    validNumbers.remove()
//                }
//
//            }
//        }
//    }
//}
