/**
 * This is a comment!
 *
 * @class: ReverseWordsinaString
 * @description: 151. Reverse Words in a String
 * @author: Xincheng Huang - xinchenh
 * @create: 02-08-2019 12:42
 **/
public class ReverseWordsinaString {
    public static String reverseWords(String s) {
        String temp = s.trim();
        String[] array = temp.split("\\s+");//一个或多个空格
        StringBuilder sb = new StringBuilder();
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] != " ")
                sb.append(array[i]).append(' ');
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("   a   b "));
    }
}
