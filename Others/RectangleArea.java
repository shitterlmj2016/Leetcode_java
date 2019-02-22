/**
 * This is a comment!
 *
 * @class: RectangleArea
 * @description: 223. Rectangle Area
 * @author: Xincheng Huang - xinchenh
 * @create: 02-18-2019 10:59
 **/
public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int left = Math.max(A, E);
        int right = Math.max(left, Math.min(C, G));
        int bottom = Math.max(B, F);
        int top = Math.max(bottom, Math.min(D, H));
        return (C - A) * (D - B) + (G - E) * (H - F) - (right - left) * (top - bottom);
    }
}
