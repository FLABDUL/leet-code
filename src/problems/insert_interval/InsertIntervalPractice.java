package problems.insert_interval;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InsertIntervalPractice {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5};
        InsertIntervalPractice insertIntervalPractice = new InsertIntervalPractice();
        System.out.println("result: " + Arrays.deepToString(insertIntervalPractice.insert(intervals, newInterval)));
    }

    private int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new LinkedList<>();
        int i=0;
        while(i< intervals.length && intervals[i][1]<newInterval[0]){
            result.add(intervals[i]);
            i++;
        }
        while(i < intervals.length && intervals[i][0]<=newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        result.add(newInterval);

        while(i<intervals.length){
            result.add(intervals[i]);
            i++;
        }
        return result.toArray(new int[result.size()][]);
    }
}
