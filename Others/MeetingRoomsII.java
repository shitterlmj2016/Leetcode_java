import java.util.Arrays;

/**
 * This is a comment!
 *
 * @class: MeetingRoomsII
 * @description:
 * @author: Xincheng Huang - xinchenh
 * @create: 01-20-2019 20:12
 **/
public class MeetingRoomsII {

    /*
    图形学
    start排序
    end排序


    start： |   |  |    |
    end:      |     | |  |
     */


    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;


        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int res = 0;
        int end = 0;

        for (int i = 0; i < intervals.length; i++) {
            if (starts[i] < ends[end])
                res++;
            else end++;
        }

        return res;
    }
}
