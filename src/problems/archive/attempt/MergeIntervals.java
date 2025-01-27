//package problems.java.archive.attempt;
//
//import java.util.Arrays;
//
//public class MergeIntervals {
//    public static void main(String[] args) {
//        int[][] intervals = {{1,3}, {2,6}, {8,10}, {15,10}};
//        MergeIntervals mergeIntervals = new MergeIntervals();
//        System.out.println("result: " + Arrays.deepToString(mergeIntervals.merge(intervals)));
//    }
//
//    public int[][] merge(int[][] intervals) {
//        int length = intervals.length;
//        int[] first = new int[length];
//        int[] second = new int[length];
//        int[][] result = new int[length][length];
//
//        for(int[] x : intervals)
//
//        int count=0;
//        for(int i=0; i<length-1; i++){
//            if(second[i]>first[i+1]){
//                result[count][count] = result[first[i]][second[i+1]];
//                i++;
//            }else{
//                result[count][count] = result[first[i]][second[i]];
//            }
//            count++;
//        }
//        return result;
//    }
//
//}
