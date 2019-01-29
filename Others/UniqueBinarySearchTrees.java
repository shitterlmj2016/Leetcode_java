/**
 * This is a comment!
 *
 * @class: UniqueBinarySearchTrees
 * @description: 96. Unique Binary Search Trees
 * @author: Xincheng Huang - xinchenh
 * @create: 01-28-2019 22:38
 **/
public class UniqueBinarySearchTrees {
    public static int numTrees(int n) {
        int[] res = new int[n + 1];
        res[0] = 1;     //4
        for (int i = 1; i < res.length; i++) {
            for (int j = 0; j < i; j++)    //j [0,i-1]
            {
                res[i] += res[j] * res[i - j - 1];
            }
        }
        return res[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }
}
