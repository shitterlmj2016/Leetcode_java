/**
 * This is a comment!
 *
 * @class: LengthofLastWord
 * @description: 58. Length of Last Word
 * @author: Xincheng Huang - xinchenh
 * @create: 01-23-2019 21:01
 **/
public class LengthofLastWord {
    //" abc d efg"
    //trim() 去掉前后空格
    public int lengthOfLastWord(String s) {
        return s.trim().length() - s.trim().lastIndexOf(" ") - 1;

        //如果不存在，lastindex 会显示 -1
        //如果全为空格，一样成立！
    }


    public static void main(String[] args) {
        System.out.println("abc".lastIndexOf("d"));
    }

}
