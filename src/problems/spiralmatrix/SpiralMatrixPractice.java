package problems.spiralmatrix;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrixPractice {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        SpiralMatrixPractice spiralMatrixPractice = new SpiralMatrixPractice();
        System.out.println("result: " + spiralMatrixPractice.spiralOrder(matrix));
    }

    private List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        if(matrix==null || matrix.length == 0) return res;
        int n = matrix.length, m = matrix[0].length;
        int up=0, down=n-1, left=0, right=m-1;
        while(res.size()<n*m){
            for(int j=left;j<=right&&res.size()<n*m;j++){//*as this will do it!
                res.add(matrix[up][j]);
            }
            for(int i=up+1;i<=down-1&&res.size()<n*m;i++){//down-1 need to nto process bottom right corner**
                res.add(matrix[i][right]);
            }
            for(int j=right; j>=left && res.size()<n*m; j--){//as this will do it!**
                res.add(matrix[down][j]);
            }
            for(int i=down-1; i>=up+1 && res.size()<n*m;i--){//up+1 needed to prevent processing top left corner*
                res.add(matrix[i][left]);
            }
            left++;right--;up++;down--;
        }
        return res;
    }
}
