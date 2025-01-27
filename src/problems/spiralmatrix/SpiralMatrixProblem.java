//package problems.java.spiralmatrix;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//public class SpiralMatrixProblem {
//    public static void main(String[] args) {
//        SpiralMatrixProblem spiralMatrixProblem = new SpiralMatrixProblem();
//        int[][] matrix = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };
//        System.out.println("result: " + spiralMatrixProblem.spiralOrder(matrix));
//    }
//
//    public List<Integer> spiralOrder(int[][] matrix) {
//        Set<Integer[][]> square = new HashSet<>();
//        int rowCount=0;
//        int columnCount=0;
//        for(int[] rows : matrix){
//            rowCount++;
//            for(int column : rows){
//                columnCount++;
//            }
//        }
//
//        int rowStart = 0;
//        int columnStart = 0;
//        int rowEnd = rowCount-1;
//        int columnEnd=columnCount-1;
//
//        List<Integer> elements = new ArrayList<>();
//        for(int current = 0; current<=rowEnd; current++){
//
//        }
//    }
