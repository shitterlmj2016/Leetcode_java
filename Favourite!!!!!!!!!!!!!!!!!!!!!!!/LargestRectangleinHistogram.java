import java.util.Stack;

/**
 * This is a comment!
 *
 * @class: LargestRectangleinHistogram
 * @description: 84. Largest Rectangle in Histogram
 * @author: Xincheng Huang - xinchenh
 * @create: 01-29-2019 20:08
 **/
public class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;

        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= heights.length; i++) {
            int h = i == heights.length ? 0 : heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] > h) {
                int height = stack.pop();
                int start = stack.isEmpty() ? -1 : stack.peek();
                int size = heights[height] * (i - start - 1);
                res = Math.max(res, size);
            }
            stack.push(i);
        }
        return res;
    }
}
