import java.util.Arrays;
import java.util.Comparator;

/**
 * This is a comment!
 *
 * @class: MeetingRooms
 * @description: 252. Meeting Rooms
 * @author: Xincheng Huang - xinchenh
 * @create: 01-20-2019 12:55
 **/



/*
[[0,30],[5,10],[15,20]]
开始和结束时间分开排序，如果有交集则不可以

有相同开始时间的可以直接排除，因次可以只排序开始时间



 */

public class MeetingRooms {
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
            return true;
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i + 1].end > intervals[i].start)
                return false;
        }


        return true;
    }

}


class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

