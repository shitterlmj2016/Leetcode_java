
//重点，双指针，只移动较短的那条边，因为移动较长边面积只会变小

public class ContainerWithMostWater {


    public static int maxArea(int[] height) {
        if (height == null && height.length == 0)
            return 0;
        int lo = 0;
        int hi = height.length - 1;

        int volume = 0;
        while (lo < hi) {
            if (Math.min(height[lo], height[hi]) * (hi - lo) > volume)
                volume = Math.min(height[lo], height[hi]) * (hi - lo);


            //这步是技巧，很重要
            if(height[lo]>height[hi])
                hi--;
            else lo++;
            //这步是技巧，很重要
        }
        return volume;
    }
}
