import java.util.Arrays;
import java.util.Comparator;

public class EraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        int count = 0;
        if (intervals.length == 0) {
            return 0;
        }
//        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int x_end = intervals[0][1];
        int x_start = intervals[0][0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= x_end) {
                x_end = intervals[i][1];
            }else {
                count++;
            }
        }
        return count;
    }
}
