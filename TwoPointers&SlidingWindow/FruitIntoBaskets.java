import java.util.HashMap;

/**
 * This is
 *
 * @class: FruitIntoBaskets
 * @description: 904. Fruit Into Baskets
 * @author: Xincheng Huang - xinchenh
 * @create: 01-19-2019 12:12
 **/
public class FruitIntoBaskets {

        //双指针+hashmap
    public int totalFruit(int[] tree) {
        if (tree == null || tree.length == 0)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        int res = 1;

        int j = 0;

        for (int i = 0; i < tree.length; i++) {
         //   if (map.size() <= 2) {
          //      map.put(tree[i], i);
          //  }

            if (map.size() > 2) {
                int min = tree.length - 1;

                for (int m : map.values()
                ) {
                    min = Math.min(min, m);

                }

                map.remove(tree[min]);

                j = min + 1;
            }

            res = Math.max(i - j+1, res);
        }


        return res;
    }
}
