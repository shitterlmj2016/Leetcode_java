import java.util.HashSet;

/**
 * This is a comment!
 *
 * @class: UniqueEmailAddresses
 * @description: 929. Unique Email Addresses
 * @author: Xincheng Huang - xinchenh
 * @create: 03-04-2019 00:18
 **/
public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        if (emails == null || emails.length == 0)
            return 0;
        HashSet<String> set = new HashSet<>();
        for (String s : emails
        ) {
            int i = 0;
            StringBuilder sb = new StringBuilder();
            while (i < s.length() && s.charAt(i) != '+' && s.charAt(i) != '@') {
                if (s.charAt(i) != '.')
                    sb.append(s.charAt(i));
                i++;
            }
            sb.append(s.split("@")[1]);
            set.add(sb.toString());
        }
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println("123@1231".split("@")[1]);
    }
}
