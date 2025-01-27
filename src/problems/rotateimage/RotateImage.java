package problems.rotateimage;

import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        RotateImage rotateImage = new RotateImage();
        rotateImage.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));

    }

    public void rotate(int[][] matrix) {
        int n= matrix.length;
        for(int i=0; i<n;i++){
            for(int j=0; j<n; j++) {
                int temp = matrix[i][n - 1];
                matrix[i][n - 1] = matrix[i][i];
            }
        }
    }
}
