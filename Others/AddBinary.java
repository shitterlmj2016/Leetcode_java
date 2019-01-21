import java.util.Stack;

public class AddBinary {

    public static String addBinary(String a, String b) {

        Stack<String> stack = new Stack<>();
        char[] aa = a.toCharArray();
        char[] bb = b.toCharArray();

        if (aa.length == 0)
            return b;
        if (bb.length == 0)
            return a;
        int size = aa.length;
        if (bb.length > aa.length)
            size = bb.length;

        int m = aa.length - 1;
        int n = bb.length - 1;
        int left = 0;

        for (int i = 0; i < size; i++) {
            int total = 0;
            if (m > -1)
                total = total + aa[m] - 48;
            if (n > -1)
                total = total + bb[n] - 48;

            total = total + left;
            m--;
            n--;

            if (total == 3) {
                stack.push("1");
                left = 1;
            }
            if (total == 2) {
                stack.push("0");
                left = 1;
            }

            if (total == 1) {
                stack.push("1");
                left = 0;
            }

            if (total == 0) {
                stack.push("0");
                left = 0;

            }

        }
        if (left == 1)
            stack.push("1");
        String re = "";
        while (!stack.isEmpty())
            re = re + stack.pop();
        return re;
    }

    public static void main(String[] args) {
        System.out.println(addBinary("1010", "1011"));
    }
}
