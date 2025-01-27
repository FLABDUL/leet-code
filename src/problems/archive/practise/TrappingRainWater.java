package problems.archive.practise;

import java.util.Arrays;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("height: " + Arrays.toString(height));
        System.out.println("trapped rain water: " + trap(height));
    }

    private static int trap(int[] height) {
        //null and 0 return 0 edge case check
        if(height==null || height.length==0){
            return 0;
        }

        //intialise pointers leftright, mix/max, total
        int left=0;
        int right=height.length-1;//last element
        int maxLeft=0;
        int maxRight=0;
        int totalWater=0;

        //while within array
            //if left less right heights
                //if left higher max
                    //assign as new max
                //else
                    //collect water
            //increment left
        //else
            //repeat
        while(left<right){
            if(height[left]<height[right]) {//possible fill
                if(height[left]>=maxLeft){
                    //new higher
                    maxLeft=height[left];
                }
                else{
                    int water = maxLeft - height[left];
                    totalWater+=water;
                }
                left++;
            }else {//go right
                if(height[right]>=maxRight){
                    maxRight=height[right];
                }else{
                    int water = maxRight-height[right];
                    totalWater+=water;
                }
                right--;
            }
        }
        return totalWater;
    }
}
