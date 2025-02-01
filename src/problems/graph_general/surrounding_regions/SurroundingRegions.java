//package problems.graph_general.surrounding_regions;
//
//import java.util.Arrays;
//
//public class SurroundingRegions {
//    public static void main(String[] args) {
//        char[][] board = {
//                {'X', 'X', 'X', 'X'},
//                {'X', 'O', 'O', 'X'},
//                {'X', 'X', 'O', 'X'},
//                {'X', 'O', 'X', 'X'}
//        };
//        System.out.println("result: " + Arrays.deepToString(board));
//    }
//
//    public void solve(char[][] board) {
//        //y = length
//        //x = 0.length
//        //for y
////            for x
//        //if O and not edge
//        //go u/r/d
//        //if 0 repeat
//        //if ever O and edge
////                skip
//        //else mark x
//        //**store checks
//        int y = board.length;
//        int x = board[0].length;
//        for (int i = 0; i < y; i++) {//y
//            for (int j = 0; j < x; j++) {//x
//                if (board[i][j] == 'O' && i != 0 && j != 0) {//not edge and marked O
//                    //dfs check
//                    mark(board, i, j+1);//go right first
//                }
//            }
//        }
//    }
//
//    private void mark(char[][] board, int i, int j){
//        if()
//
////        mark(board, i, j+1);//right
//        mark(board, i+1, j-1);//up
//        mark(board, i-1, j-1);//down
//
//    }
//}
