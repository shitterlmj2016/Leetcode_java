import java.util.HashSet;

/**
 * This is a comment!
 *
 * @class: HappyNumber
 * @description: 202. Happy Number
 * @author: Xincheng Huang - xinchenh
 * @create: 02-10-2019 00:20
 **/
public class HappyNumber {
    public boolean isHappy(int n) {

        HashSet<Integer> set = new HashSet<>();
        while (set.add(n)) {
            if (n == 1)
                return true;
            int temp = 0;
            while (n != 0) {
                temp += Math.pow(n % 10, 2);
                n = n / 10;
            }
            n = temp;
        }

        return false;
    }
}
