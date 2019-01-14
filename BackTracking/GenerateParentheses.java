
//22
//卡特兰数

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n == 0)
            return list;

        help(list, "", n, n);
        return list;
    }

    public void help(List<String> list, String s, int left, int right) {
        if (left > right)  //wrong branch (()))
            return;
        if (left == 0 && right == 0) {
            list.add(s);
            return;
        }

        if(left>0)
            help(list,s+"(",left-1,right);
        if(right>0)
            help(list,s+")",left,right-1);
    }
}
