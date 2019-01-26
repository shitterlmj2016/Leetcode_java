import java.util.ArrayList;
import java.util.List;

/**
 * This is a comment!
 *
 * @class: Combinations
 * @description: 77. Combinations
 * @author: Xincheng Huang - xinchenh
 * @create: 01-25-2019 12:35
 **/
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0 || k == 0 || k > n)
            return res;
        help(res, new ArrayList<Integer>(), n, k,0);
        return res;
    }

    private void help(List<List<Integer>> res, ArrayList<Integer> list, int n, int k,int start) {
        if (k == 0) {
            res.add(new ArrayList<>(list));  //必须要new一个，不然传的是同一个参数
            return;
        }

        for (int i = start+1; i <= n; i++) {
           // if (list.size() == 0 || list.get(list.size() - 1) < i) {
                list.add(i);
                help(res, list, n, k - 1,i);
                list.remove(list.size() - 1);
          //  }
        }
    }

    public static void main(String[] args) {
//        Combinations c = new Combinations();
//        System.out.println(c.combine(5, 3));
        System.out.println((Object) 123);
    }
}

