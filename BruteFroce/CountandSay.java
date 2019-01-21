/**
 * This is a comment!
 *
 * @class: CountandSay
 * @description: 38. Count and Say
 * @author: Xincheng Huang - xinchenh
 * @create: 01-20-2019 20:57
 **/
public class CountandSay {
    public String countAndSay(int n) {
        int i = 1;
        String res = "1";

        // 111221

        while (i < n) {
            StringBuilder sb = new StringBuilder();
            char c = res.charAt(0);
            int count = 0;
            for (int j = 0; j <= res.length(); j++) {//<=很关键！！！！多一步把最后一个字符加进去
                if (j < res.length() && c == res.charAt(j))
                    count++;

                else {//到结尾或者遇到一个不同的字符
                    sb.append(count);
                    sb.append(c);
                    if (j < res.length()) {
                        count = 1;
                        c = res.charAt(j);
                    }
                }
            }

            res = sb.toString();

            i++;
        }

        return res;
    }
}
