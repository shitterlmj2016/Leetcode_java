import java.util.HashSet;

/**
 * This is a comment!
 *
 * @class: JewelsandStones
 * @description: 771. Jewels and Stones
 * @author: Xincheng Huang - xinchenh
 * @create: 01-18-2019 10:03
 **/
public class JewelsandStones {


    /*
    HashSet
     */

    public int numJewelsInStones(String J, String S) {
        if (S == null || J == null || S.length() == 0 || J.length() == 0)
            return 0;


        int res = 0;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }
        for (int i = 0; i < S.length(); i++) {
            if (set.contains(S.charAt(i)))
                res++;
        }
        return  res;
    }


}
