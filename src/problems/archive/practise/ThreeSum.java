package problems.archive.practise;

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

    private List<List<Integer>> threeSum(int[] nums) {
        //result object setup
        //sort array
        //loop and skip if duplicate
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length;i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            //set j+ and k last
            //cycle up
            //total found
            //more then right down
            //less than left up
            //else add to res and left up
            //check duplicates j
            int j = i + 1, k = nums.length - 1;
            while(j<k){
                int total = nums[i]+nums[j]+nums[k];
                if(total > 0){
                    k--;
                }else if(total < 0){
                    j++;
                }else{
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    while(nums[j]==nums[j-1] && j<k){
                        j++;
                    }
                }
            }
        }
        return res;
    }


}
