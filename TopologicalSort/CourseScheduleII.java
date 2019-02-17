import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This is a comment!
 *
 * @class: CourseScheduleII
 * @description: Course Schedule II
 * @author: Xincheng Huang - xinchenh
 * @create: 02-15-2019 22:02
 **/
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] list = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            list[i] = new ArrayList<>();
        }
        int[] indegree = new int[numCourses];

        for (int[] course : prerequisites
        ) {
            indegree[course[0]]++;
            list[course[1]].add(course[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;
        int res[] = new int[numCourses];

        while (!queue.isEmpty()) {
            int course = queue.poll();
            res[count++] = course;  //注意count只会少不会多
            for (int i : list[course]
            ) {
                if (indegree[i] != 0) {
                    if (--indegree[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }
        return count == numCourses ? res : new int[]{};
    }
}
