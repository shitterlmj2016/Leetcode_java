public class LongestCommonPrefix {

        //重点： string.indexof 方法

    //time: o(n)
    //space:o(1)

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return null;

        String res = strs[0];
        for (int i = 0; i <strs.length ; i++) {
            while(strs[i].indexOf(res)!=0)
                res = res.substring(0,res.length()-1);
        }

        return res;
    }


    public static void main(String[] args) {

        System.out.println("dogg".indexOf("ga"));
    }
}
