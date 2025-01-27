package problems.archive.attempt;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("height: " + height);
        System.out.println("trapped water: " + trap(height));
    }

    public static int trap(int[] height) {
        int totalTrappedWater = 0;

        for(int level: height){
            totalTrappedWater+=sum(height);
            height[level]--;
        }

        return totalTrappedWater;
    }

    public static int sum(int[] height){
        int trappedWater = 0;

        for(int i=0; i< height.length-1; i++){
            if(height[i]>0){
                for(int j=i+1; j<height.length; j++){
                    if(height[j]==0){
                        trappedWater++;
                    }else{
                        break;
                    }
                }
            }
        }
        return trappedWater;
    }
    //new array is height - 1 per elemnt
    //recur as many times as max height
    //loop through each array level
    //if open check centre
    //add to sum
}
