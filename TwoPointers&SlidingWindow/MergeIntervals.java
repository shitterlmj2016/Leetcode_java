import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a comment!
 *
 * @class: MergeIntervals
 * @description: 56. Merge Intervals
 * @author: Xincheng Huang - xinchenh
 * @create: 01-23-2019 13:28
 **/
/*
与meeting rooms是一类
记住  Collections.sort(intervals,(a,b)->a.start-b.start);

自己做出来的 O(nlogn)
 */

//[[1,3],[2,6],[8,10],[15,18]]
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0)
            return res;

        Collections.sort(intervals, (a, b) -> a.start - b.start); //记住怎么写
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start > end) {
                res.add(new Interval(start, end));
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            } else {
                end = Math.max(end, intervals.get(i).end);
            }
        }

        res.add(new Interval(start, end));
        return res;
    }
}

