public class LongestPalindromicSubstring {

    // 1 dp
    public static String longestPalindrome(String s) {
        if (s == null && s.length() == 0)
            return s;
        String res = "";
        int max = 0;
        boolean [][] dp = new boolean[s.length()][s.length()];
        for (int j = 0; j <s.length() ; j++) {
            for (int i = 0; i <=j ; i++) {//这里是<=
                dp[i][j] = (s.charAt(i)==s.charAt(j)&&(j-i<=2||(dp[i+1][j-1])));//i+1 j-1
                if(dp[i][j])
                {
                    int len = j-i+1;
                    if(len>max)
                    {
                        max = len;
                        res = s.substring(i,j+1);//j+1
                    }

                }

            }
        }
        return res;
    }

    // 2 中心扩散
        //两种情况
    // x-y-x || x-y-y-x

    
    String res = "";
    int len = 0;
    public  String longestPalindrome2(String s)
    {

        if(s==null||s.length()==0)
            return s;
        for (int i = 0; i <s.length() ; i++) {
            help(s,i,i);
            help(s,i,i+1);
        }
        
        return res;
    }

    public void help(String s, int i, int j)
    {
        while(i>=0&&j<s.length()&&s.charAt(i) == s.charAt(j)) {
                if((j-i+1)>len)
                {
                    len = j-i+1;
                    res = s.substring(i,j+1);
                }
                i--;
                j++;
        }
    }
    
    


    public static void main(String[] args) {
        LongestPalindromicSubstring l = new LongestPalindromicSubstring();
        System.out.println(l.longestPalindrome2("abcba"));
    }
}
