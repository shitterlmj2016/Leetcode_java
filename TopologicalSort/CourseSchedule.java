import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This is a comment!
 *
 * @class: CourseSchedule
 * @description: 207. Course Schedule
 * @author: Xincheng Huang - xinchenh
 * @create: 02-13-2019 20:59
 **/
public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
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
            if (indegree[i] == 0)
                queue.offer(i);
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int i : list[course]
            ) {
                if (indegree[i] != 0) {
                    if (--indegree[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }
        return count == numCourses;
    }

    public static void main(String[] args) {
        int[][] a = {{0, 1}};
        System.out.println(canFinish(2, a));
    }
}
