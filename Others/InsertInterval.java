import java.util.ArrayList;
import java.util.List;

/**
 * This is a comment!
 *
 * @class: InsertInterval
 * @description: 57. Insert Interval
 * @author: Xincheng Huang - xinchenh
 * @create: 01-23-2019 16:49
 **/


////最巧妙的地方!!!!!!!!!!!!!!!!!!!!!!
//        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
//        newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
//        newInterval.end = Math.max(intervals.get(i++).end, newInterval.end);
//        }

public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {


        /*

        |_|  |___|  |_| |__|
                |___|

         */

        if (newInterval == null ) //注意这里是什么！ 
            return intervals;

        List<Interval> res = new ArrayList<>();
        int i = 0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            res.add(intervals.get(i++));
        }

        //最巧妙的地方!!!!!!!!!!!!!!!!!!!!!!
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(i++).end, newInterval.end);
        }
        res.add(newInterval);
        while (i < intervals.size()) {
            res.add(intervals.get(i++));
        }

        return res;
    }
}
