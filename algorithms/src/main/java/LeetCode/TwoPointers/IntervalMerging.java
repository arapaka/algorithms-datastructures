package LeetCode.TwoPointers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by archithrapaka on 4/10/17.
 */
public class IntervalMerging {


    static class Interval {
        int start;
        int end;

        Interval(int start , int end) {
            this.start = start;
            this.end = end;
        }
        public int getStart() {
            return start;
        }
        public int getEnd() {
            return end;
        }
        public void setStart(int start) {
            this.start = start;
        }
        public void setEnd(int end) {
            this.end = end;
        }
    }

    public static void mergeIntervals(List<Interval> intervals) {
        if(intervals == null || intervals.isEmpty()) {
            return;
        }
        // sort based on the start
        intervals.sort(Comparator.comparing(Interval::getStart));
         List<Interval> result = new ArrayList<>();
         // first start and end
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval interval:intervals) {
             if (interval.start <= end) {
                 end = Math.max(end,interval.end);
             }
            else {
                 result.add(new Interval(start,end));
                 start = interval.start;
                 end = interval.end;
             }
        }

        result.add(new Interval(start,end));
        for (Interval interval:result) {
            System.out.print("["+interval.start+","+interval.end+"]");
            System.out.print(" ");
        }
    }
    public static void main(String[] args) {
         List<Interval> list = new ArrayList<>();
         list.add(new Interval(1,2));
        list.add(new Interval(2,5));
        list.add(new Interval(1,5));
        list.add(new Interval(5,7));
        list.add(new Interval(1,7));
        list.add(new Interval(7,8));
        mergeIntervals(list);
    }
}
