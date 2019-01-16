public class ImplementstrStr {

    public static int strStr(String haystack, String needle) {
        if (needle==null||needle.length()==0)
            return 0;
        for (int i = 0; i <haystack.length()-needle.length()+1 ; i++) {
            if(haystack.substring(i,i+needle.length()).compareTo(needle)==0)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("ABC","C"));

    }
}
