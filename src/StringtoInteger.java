


//s.trim delete empty space before and after a string
public class StringtoInteger {

    public static int myAtoi(String str) {


        str = str.trim();//delete empty spaces

        if (str == null || str.length() == 0)
            return 0;
//放在后面，解决掉 str = ‘ ’ 这种情况
        int sign = 1;
        long res = 0;
        int start = 0;
        if (str.charAt(start) == '-') {
            start++;
            sign = -1;
        } else if (str.charAt(start) == '+') {
            start++;
        }

        for (int i = start; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i)))
                return (int) res * sign;
            res = res * 10 + str.charAt(i)-'0';   //** char number - 0 -> integer
            if (sign == 1 && res > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (sign == -1 && 0-res  < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;

        }
        return (int) res * sign;
        //Math.abs(Integer.MIN_VALUE) 还是负数

    }


    public static void main(String[] args) {

        System.out.println(myAtoi("-42"));
        System.out.println(Math.abs(Integer.MIN_VALUE));
    }
}
