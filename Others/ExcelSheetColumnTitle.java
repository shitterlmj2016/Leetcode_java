/**
 * This is a comment!
 *
 * @class: ExcelSheetColumnTitle
 * @description: 168. Excel Sheet Column Title
 * @author: Xincheng Huang - xinchenh
 * @create: 02-12-2019 14:06
 **/
public class ExcelSheetColumnTitle {
    public static String convertToTitle(int n) {
        if (n < 1)
            return "";
        StringBuilder sb = new StringBuilder();
        sb.append(convertToTitle((n - 1) / 26)).append((char) ((n - 1) % 26 + 'A'));
        return sb.toString();
    }

    public static void main(String[] args) {
        convertToTitle(1);
    }
}
