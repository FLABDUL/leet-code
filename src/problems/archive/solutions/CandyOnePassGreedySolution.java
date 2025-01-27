package problems.archive.solutions;

import java.util.Arrays;

public class CandyOnePassGreedySolution {
    public static void main(String[] args) {
        int[] test = new int[]{1, 0, 2};
        System.out.println(candy(test));
    }

    public static int candy(int[] ratings){
        //length
        //new candies array
        //fill with ones
        int length = ratings.length;
        int[] candies = new int[length];
        Arrays.fill(candies, 1);

        //loop 2nd to last
            //if right more than left
                //right=left++
        for(int i = 1; i < length - 1; i++){
            if(ratings[i] > ratings[i-1]){
                candies[i] = candies[i-1]+1;
            }
        }

        //loop second last to first
            //if left more than right
                //take max of current or right++
        for(int i = length - 2; i >= 0; i--){
            if(ratings[i] > ratings[i+1]){
                candies[i] = Math.max(candies[i], candies[i+1]+1);
            }
        }

        //count total candies
        //return
        int totalCandies = 0;
        for(int candy: candies){
            totalCandies+=candy;
        }
        return totalCandies;
    }
}
