
//非常重要！
//log（min(n,m)）

public class MedianofTwoSortedArrays {


    //1.11 自己解
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int m = 0;
        int n = 0;
        if (total % 2 == 0) {
            int target = total / 2;
            double re1 = 0;
            double re2 = 0;
            for (int i = 0; i <= target; i++) {
                if (nums1.length!=0&&m<nums1.length&&(n>=nums2.length||nums1[m] < nums2[n])) {

                    re1 = re2;
                    re2 = nums1[m];
                    m++;
                } else {

                    re1 = re2;
                    re2 = nums2[n];
                    n++;
                }
            }
            return (re1 + re2) / 2;

        }
        else {
            int target = total / 2;
            int re = 0;
            for (int i = 0; i <= target; i++) {
                if (nums1.length!=0&&m<nums1.length&&(n>=nums2.length||nums1[m] < nums2[n])) {

                    re = nums1[m];
                    m++;
                } else {

                    re = nums2[n];
                    n++;
                }
            }
            return re;
        }

    }


    //1.11 最优解 直接看solution，不是视频

    public static void main(String[] args) {
        int []a = {1,2};
        int []b ={3,4};
        System.out.println(findMedianSortedArrays(a,b));
    }

}
