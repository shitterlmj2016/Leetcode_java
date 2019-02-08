/**
 * This is a comment!
 *
 * @class: StringWithoutAAAorBBB
 * @description: 984. String Without AAA or BBB
 * @author: Xincheng Huang - xinchenh
 * @create: 02-07-2019 17:58
 **/
public class StringWithoutAAAorBBB {
    public String strWithout3a3b(int A, int B) {
        if (B > A)
            return reverse(strWithout3a3b(B, A));
        int a = A;
        int b = B;
        StringBuilder sb = new StringBuilder();
        while (a > 0 && b > 0) {
            if (a == b) {
                sb.append(A);
                sb.append(B);
                a--;
                b--;
            } else if (a > b) {
                sb.append(A).append(A);
                sb.append(B);
                a -= 2;
                b--;
            } else {
                sb.append(A);
                sb.append(B).append(B);
                a--;
                b -= 2;
            }
        }

        if (a > 0) {
            for (int i = 0; i < a; i++) {
                sb.append(A);
            }
        }

        if (b > 0) {
            for (int i = 0; i < b; i++) {
                sb.append(B);
            }
        }
        return sb.toString();
    }

    private String reverse(String strWithout3a3b) {

        StringBuilder sb = new StringBuilder();
        for (char c : strWithout3a3b.toCharArray()
        ) {
            if (c == 'a')
                sb.append('b');
            if (c == 'b')
                sb.append('a');
        }
        return sb.toString();
    }

//    private String helper(int a, int aLength, int b, int bLength) {
//        if (aLength > bLength)
//            return helper(b, bLength, a, aLength);
//        StringBuilder sb = new StringBuilder();
//
//        if (aLength == 0) {
//            for (int i = 0; i < bLength; i++) {
//                sb.append(b);
//            }
//            return sb.toString();
//        }
//
//        if (bLength == 0) {
//            for (int i = 0; i < aLength; i++) {
//                sb.append(a);
//            }
//            return sb.toString();
//        }
//
//        for (int i = 0; i < bLength && i < 2; i++) {
//            sb.append(b);
//        }
//        for (int i = 0; i < ; i++) {
//
//        }
}
