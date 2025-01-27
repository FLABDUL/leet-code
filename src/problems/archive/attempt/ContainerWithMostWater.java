package problems.archive.attempt;

import java.util.Arrays;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        System.out.println("for height: " + Arrays.toString(height) + " - the most water is: " + containerWithMostWater.maxArea(height));
    }

    public int maxArea(int[] height) {
        //left and right and max left max right
        int left = 0, right = height.length-1, maxLeft = 0, maxRight = height.length-1, sum=0, maxSum=0;
        while(left<right){
            System.out.println("left index: " + left + " left height: " + height[left]);
            System.out.println("right index: " + right + " right height: " + height[right]);
            sum=height[left]*height[right];
            System.out.println("sum: " + sum);
            if(sum>maxSum){
                maxSum=sum;
                System.out.println("maxSum: " + maxSum);
            }
            left++;
            right--;
        }
        return maxSum;
    }
}
