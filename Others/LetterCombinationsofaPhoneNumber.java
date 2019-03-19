
//17
//BFS recursive



import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {


    String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<String>();
        if (digits == null || digits.length() == 0)
            return list;

        String res = "";

        help(digits, 0, res, list);

        return list;


    }


    public void help(String digits, int index, String res, List<String> list) {
        if (index == digits.length()) {
            list.add(res);
            return;
        }

        String str = mapping[digits.charAt(index)-'0'];

        for (int i = 0; i <str.length() ; i++) {
            help(digits,index+1,res+str.charAt(i),list);
        }
    }

}
