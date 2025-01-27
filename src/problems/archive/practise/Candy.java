package problems.archive.practise;

public class Candy {
    public static void main(String[] args) {
        int[] test1 = {1, 0, 2};
        System.out.println(candy(test1));

        int[] test2 = {1, 2, 2};
        System.out.println(candy(test2));

        int[] test3 = {3};
        System.out.println(candy(test3));

        int[] test4 = {1, 2};
        System.out.println(candy(test4));
    }

    public static int candy(int[] ratings){
        int length = ratings.length;
        int candy = 1;//count
        int mostCandy = length;
        //min=1
        //max=length
        if(length==1){
            return 1;
        }else if(length==2){
            return 3;
        }
        candy+=2;//for first and last min count
        for(int i = 1; i < length - 1; i++){
           if(ratings[i] > ratings[i-1] && ratings[i] > ratings[i+1]){
               candy+=2;
           }else if(ratings[i]> ratings[i-1] || ratings[i] > ratings[i+1]){
               candy++;
           }else{
               candy+=2;
           }
        }
        return candy;
    }
}
