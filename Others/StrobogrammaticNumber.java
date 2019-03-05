/**
 * This is a comment!
 *
 * @class: StrobogrammaticNumber
 * @description: Strobogrammatic Number
 * @author: Xincheng Huang - xinchenh
 * @create: 02-25-2019 12:58
 **/
public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        if (num == null || num.length() == 0)
            return true;
        int i = 0;
        int j = num.length() - 1;
        while (i <= j) {
            if (!"00 11 88 696".contains(num.charAt(i) + "" + num.charAt(j)))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public boolean isStrobogrammatic2(String num) {
        if (num == null || num.length() == 0)
            return true;
        if (num.length() == 1) {
            char c = num.charAt(0);
            if (c != '1' && c != '0' && c != '8')
                return false;
        }

        for (int i = 0; i < num.length() - 1; i++) {
            char m = num.charAt(i);
            char n = num.charAt(num.length() - 1 - i);
            if (m == '1') {
                if (n != '1')
                    return false;
            } else if (m == '0') {
                if (n != '0')
                    return false;
            } else if (m == '6') {
                if (n != '9')
                    return false;
            } else if (m == '8') {
                if (n != '8')
                    return false;
            } else if (m == '9') {
                if (n != '6')
                    return false;
            } else return false;
        }
        return true;
    }
}
