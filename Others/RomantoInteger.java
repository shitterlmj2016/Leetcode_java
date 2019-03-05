public class RomantoInteger {

    public static int romanToInt(String s) {

        if (s == null || s.length() == 0)
            return 0;
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "v", "IV", "I"};
        int[] val = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        int start = 0;
        int res = 0;
        for (int i = 0; i < roman.length; i++) {       //注意下面是小于等于！！！
            while (start < s.length()&&(start + roman[i].length()<=s.length())&&roman[i].compareTo(s.substring(start, start + roman[i].length()))==0) {
                    start += roman[i].length();
                    res += val[i];
            }

        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println("123".substring(0,0));
    }
}
