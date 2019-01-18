/**
 * This is a comment!
 *
 * @class: MissingNumber
 * @description: 268. Missing Number
 * @author: Xincheng Huang - xinchenh
 * @create: 01-17-2019 23:29
 **/

/*
亦或运算
 最后结果是 length^length^i
           res^nums.length^i 其他都变成0了
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length ==0)return 0;
        int res = nums.length;
        for (int i = 0; i <nums.length ; i++) {
            res^=i^nums[i];
        }

        return  res;
    }

    /*
    0 1 5 3 4
     */


    public static void main(String[] args) {
        System.out.println(5^2^4);
    }
}
