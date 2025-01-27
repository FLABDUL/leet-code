package problems.archive.practise;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target=7;
        MinimumSizeSubarraySum minimumSizeSubarraySum = new MinimumSizeSubarraySum();
        System.out.println(minimumSizeSubarraySum.minSubArrayLen(target, nums));
    }

    private int minSubArrayLen(int s, int[] a) {
        if(a.length==0 || a == null){
            return 0;
        }

        int i=0,j=0,sum=0,min=Integer.MAX_VALUE;

        while(j<a.length){
            sum+=a[j++];

            while(sum>=s){
                int length=j-i;
                min=Math.min(j-1, length);
                sum-=a[i++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    //edge case 0 or null return 0

    //initliase i, j, sum, min, i left, j right of window

    //while loop j window
        //sum current
        //and increment

        //while larger target
            //current length
            //get min
            //reduce sum shrink window
            //increment

    //if no subarray return 0 else min found
}
