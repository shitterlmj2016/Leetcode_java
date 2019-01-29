import java.util.ArrayList;
import java.util.List;

/**
 * This is a comment!
 *
 * @class: PascalsTriangle
 * @description: 118. Pascal's Triangle
 * @author: Xincheng Huang - xinchenh
 * @create: 01-28-2019 20:15
 **/
public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows <= 0)
            return res;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(0, 1);
            for (int j = 1; j < i; j++) {
                list.set(j, list.get(j) + list.get(j + 1));
            }
            res.add(new ArrayList<>(list)); //new new new new new
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(generate(6));
    }
}
