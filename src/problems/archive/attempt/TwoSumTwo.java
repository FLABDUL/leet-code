package problems.archive.attempt;

import java.util.Arrays;

public class TwoSumTwo {
    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;
        System.out.println("numbers :" + Arrays.toString(numbers) + " target: " + target);
        System.out.println("twoSum: " + Arrays.toString(twoSum(numbers, target)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int front = 0, back = numbers.length-1, sum = 0;
        while(front<back){
            sum=numbers[front]+numbers[back];
            if(sum==target){
                return new int[]{front+1,back+1};
            }else if(sum<target){
                front++;
            }else{
                back--;
            }
        }
        return new int[]{front+1,back+1};
    }
}
