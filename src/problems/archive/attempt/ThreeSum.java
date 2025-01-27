package problems.archive.attempt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println("input: " + Arrays.toString(nums));
        ThreeSum threeSum = new ThreeSum();
        System.out.println("result: " + threeSum.threeSum(nums));
    }

//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        int i=0, j=1, k=2;
//        while(k<nums.length-1){
//            if(nums[i] + nums[j] + nums[k] == 0){
//                result.add(List.of(new Integer[]{nums[i], nums[j], nums[k]}));
//            }
//            k++;
//        }
//
//        while(j<nums.length-2){
//            if(nums[i] + nums[j] + nums[k] == 0){
//                result.add(List.of(new Integer[]{nums[i], nums[j], nums[k]}));
//            }
//            j++;
//        }
//
//        while(i<nums.length-3){
//            if(nums[i] + nums[j] + nums[k] == 0){
//                result.add(List.of(new Integer[]{nums[i], nums[j], nums[k]}));
//            }
//            i++;
//        }
//        return result;
//    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int i=0, j=1, k=2;
        while(k<nums.length-1){
            if(nums[i] + nums[j] + nums[k] == 0){
                result.add(List.of(new Integer[]{nums[i], nums[j], nums[k]}));
            }
            k++;
        }
        k=2;

        while(j<nums.length-1){
            if(nums[i] + nums[j] + nums[k] == 0){
                result.add(List.of(new Integer[]{nums[i], nums[j], nums[k]}));
            }
            j++;
        }
        j=1;

        while(i<nums.length-1){
            if(nums[i] + nums[j] + nums[k] == 0){
                result.add(List.of(new Integer[]{nums[i], nums[j], nums[k]}));
            }
            i++;
        }
        i=0;
        return result;
    }
}
