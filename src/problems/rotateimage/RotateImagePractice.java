package problems.rotateimage;

import java.util.Arrays;

public class RotateImagePractice {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        RotateImagePractice rotateImagePractice = new RotateImagePractice();
        rotateImagePractice.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    private void rotate(int[][] matrix) {
        //transpose
        for(int i=0; i<matrix.length; i++){
            for(int j=i; j< matrix[0].length; j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        //flip horizontally
        for(int i=0;i< matrix.length;i++){
            for(int j=0; j< matrix.length/2;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j]=temp;
            }
        }
    }
}
