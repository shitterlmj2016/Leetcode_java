public class PalindromeNumber {


    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        String s = Integer.toString(x);
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;

    }


    public static boolean isisPalindrome(int x)
    {
        if(x<0||x>0&&x%10 ==0)
            return false;

        int reverse = 0;
        while(reverse<x)
        {
            reverse = reverse*10+ x%10;
            x=x/10;
        }

        return (reverse ==x ||reverse/10==x);//保证奇数位和偶数位两种情况都相同 前偶数 后奇数


    }

}
