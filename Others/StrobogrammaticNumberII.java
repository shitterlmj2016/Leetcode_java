import java.util.ArrayList;
import java.util.List;

/**
 * This is a comment!
 *
 * @class: StrobogrammaticNumberII
 * @description: Strobogrammatic Number II
 * @author: Xincheng Huang - xinchenh
 * @create: 03-04-2019 13:16
 **/
public class StrobogrammaticNumberII {


    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }

    private List<String> helper(int n, int m) {
        ArrayList<String> res = new ArrayList<>();
        if (n == 0) {
            res.add("");
            return res;
        }
        if (n == 1) {
            res.add("0");
            res.add("1");
            res.add("8");
            return res;
        }

        List<String> middleware = helper(n - 2, m);
        for (
                String s : middleware
        ) {
            if (n != m) {
                res.add("0" + s + "0");
            }
            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("8" + s + "8");
            res.add("9" + s + "6");
        }
        return res;
    }
}

