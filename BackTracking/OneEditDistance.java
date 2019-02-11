/**
 * This is a comment!
 *
 * @class: OneEditDistance
 * @description: One Edit Distance
 * @author: Xincheng Huang - xinchenh
 * @create: 02-10-2019 22:26
 **/
public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {


        for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length())
                    if (s.substring(i + 1).equals(t.substring(i + 1)))
                        return true;
                    else return false;
                else if (s.length() > t.length()) {
                    if (s.substring(i + 1).equals(t.substring(i)))
                        return true;
                    else
                        return false;
                } else return isOneEditDistance(t, s);
            }
        }
        if (Math.abs(s.length() - t.length()) == 1)//"a" , ""
            return true;
        return false; //两个完全相同
    }
}
