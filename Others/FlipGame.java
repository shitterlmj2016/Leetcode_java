import java.util.ArrayList;
import java.util.List;

/**
 * This is a comment!
 *
 * @class: FlipGame
 * @description: Flip Game
 * @author: Xincheng Huang - xinchenh
 * @create: 03-04-2019 20:48
 **/
public class FlipGame {
    public static List<String> generatePossibleNextMoves(String s) {
        if (s == null || s.length() <= 1)
            return new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        ArrayList<String> res = new ArrayList<>();
        for (int i = 1; i < sb.length(); i++) {
            if (sb.charAt(i) == '+' && sb.charAt(i - 1) == '+') {
                sb.setCharAt(i, '-');
                sb.setCharAt(i - 1, '-');
                res.add(sb.toString());
                sb.setCharAt(i, '+');
                sb.setCharAt(i - 1, '+');
            }
        }
        return res;
    }

    public static void main(String[] args) {
        generatePossibleNextMoves("++++");
    }
}
