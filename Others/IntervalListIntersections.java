import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * This is a comment!
 *
 * @class: IntervalListIntersections
 * @description: 986. Interval List Intersections
 * @author: Xincheng Huang - xinchenh
 * @create: 02-07-2019 22:06
 **/
public class IntervalListIntersections {
    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        ArrayList<Interval> temp = new ArrayList<>();
        ArrayList<Interval> res = new ArrayList<>();
        for (Interval i : A
        ) {
            temp.add(i);
        }
        for (Interval i : B
        ) {
            temp.add(i);
        }
        Collections.sort(temp, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start > o2.start)
                    return 1;
                else if (o1.start < o2.start)
                    return -1;
                else if (o1.end == o2.end)
                    return 0;
                else return o1.end - o2.end;
            }
        });

        for (int i = 0; i < temp.size() - 1; i++) {
            if (temp.get(i).end >= temp.get(i + 1).start)
                res.add(new Interval(temp.get(i + 1).start, temp.get(i).end));
        }

        return res.toArray(new Interval[res.size()]);
    }
}
