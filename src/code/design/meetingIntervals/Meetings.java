package code.design.meetingIntervals;

import java.util.*;

public class Meetings {
    public static void main(String[] args) {
        int[][] intervals = {{10,20},{5,16},{2,6}};
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        System.out.println(Arrays.deepToString(intervals));
    }

    public static boolean[] solveIntervals(int[][] input, int k) {

        int kStart = input[k][0];
        int kEnd = input[k][1];

        boolean[] attend = new boolean[input.length];
        attend[k] = true;

        for (int i = 0; i < input.length; i++) {
            if (i != k) {
                int start = input[i][0];
                int end = input[i][1];

                if (start < kEnd && kEnd <= end) attend[i] = false;
                else if (start <= kStart && kStart < end) attend[i] = false;
                else if (start <= kStart && kEnd <= end) attend[i] = false;
                else attend[i] = true;
            }
        }

        return attend;
    }

    public static class Interval {
        public int start;
        public int end;
        public int overlaps = 0;

        public Interval (int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}
