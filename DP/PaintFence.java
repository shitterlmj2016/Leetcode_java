/**
 * This is a comment!
 *
 * @class: PaintFence
 * @description: 276. Paint Fence
 * @author: Xincheng Huang - xinchenh
 * @create: 03-02-2019 00:05
 **/
public class PaintFence {
    public int numWays(int n, int k) {
        if (n == 0)
            return 0;
        if (n == 1)
            return k;
        int same = k;
        int different = k * (k - 1);
        for (int i = 2; i < n; i++) {
            int temp = different;
            different = (k - 1) * (same + different);
            same = temp;
        }
        return same + different;
    }
}
