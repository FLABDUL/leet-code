package problems.archive.practise;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        System.out.println(containerWithMostWater.maxArea(height));
    }

    public int maxArea(int[] height) {
        //intiliase left, right, max
        //whie towards centre
        //current area
        //max area
        int left = 0, right = height.length-1, max = 0;
        while(left<right){
            int curr = Math.min(height[left], height[right])*(right-left);
            max = Math.max(curr, max);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }

        //movement
        return max;
    }
}
