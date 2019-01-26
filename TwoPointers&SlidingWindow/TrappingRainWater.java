/**
 * HARD
 *
 * @class: TrappingRainWater
 * @description: 42. Trapping Rain Water
 * @author: Xincheng Huang - xinchenh
 * @create: 01-20-2019 20:32
 **/
public class TrappingRainWater {
//背下来，自己走一遍
    /*            *
          *       * *   *
      *   * *   * * * * *
    0 1 2 3 4 5 6 7 8 9 0

     */


    public int trap(int[] height) {
        if (height == null || height.length == 0)
            return 0;


        int lo = 0;
        int hi = height.length - 1;

        int loMax = 0;
        int hiMax = 0;
        int res = 0;

        while (lo < hi) {
            if (height[lo] < height[hi]) {
                loMax = Math.max(loMax, height[lo]);
                res += loMax - height[lo];
                lo++;
            } else {
                hiMax = Math.max(hiMax, height[hi]);
                res += hiMax - height[hi];
                hi--;
            }
        }

        return res;
    }
}
