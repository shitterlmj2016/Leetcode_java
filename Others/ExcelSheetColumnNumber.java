/**
 * This is a comment!
 *
 * @class: ExcelSheetColumnNumber
 * @description: Excel Sheet Column Number
 * @author: Xincheng Huang - xinchenh
 * @create: 02-12-2019 21:53
 **/
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = res * 26 + s.charAt(i) - 'A' + 1;
        }
        return res;
    }

    public String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();
        while (n != 0) {
            n--;
            res.append(n % 26 + 'A');
            n /= 26;
        }
        return res.reverse().toString();
    }
}
