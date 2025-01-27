package problems.archive.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();

        // Test case
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println("Input intervals: " + Arrays.deepToString(intervals));

        int[][] merged = mergeIntervals.merge(intervals);
        System.out.println("Output merged intervals: " + Arrays.deepToString(merged));

    }

    private int[][] merge(int[][] intervals) {
        //edge case length<=1 return itself
        if(intervals.length<=1){
            return intervals;
        }

        //sort intervals using comparator for first index
        Arrays.sort(intervals, Comparator.comparingInt(i->i[0]));

        //create new result index in lsit form
        List<int[]> result = new ArrayList<>();

        //create new interval array with just first array
        //add to result
        int[] newInterval = intervals[0];
        result.add(newInterval);

        //loop through each interval
            //if interval less newinterval
            //take max intervals
        //else
            //take current
            //add to resykt
        for(int[] interval : intervals){
            if(interval[0]<newInterval[1]){
                newInterval[1]=Math.max(newInterval[1], interval[1]);
            }else{
                newInterval=interval;
                result.add(newInterval);
            }

        }

        //convert back to array 2D
        //return
        int[][] mergedIntervals = result.toArray(new int[result.size()][]);
        return mergedIntervals;
    }

}
