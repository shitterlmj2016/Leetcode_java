import java.util.ArrayList;
import java.util.List;

/**
 * This is a comment!
 *
 * @class: PascalsTriangleII
 * @description: 119. Pascal's Triangle II
 * @author: Xincheng Huang - xinchenh
 * @create: 01-28-2019 21:50
 **/
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {

        //从第0行开始，记住了！
        List<Integer> res = new ArrayList<>();
        if (rowIndex < 0)
            return res;

        for (int i = 0; i <= rowIndex; i++) {
            res.add(0, 1);
            for (int j = 1; j < i; j++) {
                res.set(j, res.get(j) + res.get(j + 1));
            }
        }
        return res;
    }
}
