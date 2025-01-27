package problems.archive.attempt;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
//        int[] nums = {2,3,1,2,4,3};
        int[] nums = {1,1,1,1,1,1,1,1};
//        int target=7;
        int target=11;
        MinimumSizeSubarraySum minimumSizeSubarraySum = new MinimumSizeSubarraySum();
        System.out.println(minimumSizeSubarraySum.minSubArrayLen(target, nums));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int minLength = 0, sum = 0;
        for(int i = 0; i < nums.length - 1; i++){
//            System.out.println("i, nums[i]: " + i + ", " + nums[i]);
            for(int j = i; j < nums.length - 1; j++){
//                System.out.println("j, nums[j]: " + j + ", " + nums[j]);
                sum+=nums[j];
                System.out.println("sum: " + sum);
                if(sum==target){
                    System.out.println("hit target, i: " + i + " j: " + j);
                    minLength=j-i;
                }else if(sum>target){
                    sum=0;
                    break;
                }
            }
        }

        return minLength;
    }
}
