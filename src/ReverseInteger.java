import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

///注意负数的余数也是负的，不用担心正负！
// 会有overflow！！
public class ReverseInteger {
    public static int reverse(int x) {
        if (x == 0)
            return x;
       // boolean nega = x < 0; 不用

        Queue<Integer> s = new LinkedList<>(); //
        while (x != 0) {
            s.add(x % 10);
            x = x / 10;

        }

        while (!s.isEmpty()) {

            if(x>214748364||(x==214748364&&s.peek()>7))//overflow
                return 0;
            if(x<Integer.MIN_VALUE/10||(x==Integer.MIN_VALUE)&&s.peek()<-8)//overflow
                return 0;


            x = x * 10;
            x += s.poll();
        }

//        if (nega)
//            return 0 - x;
//        else
//
        return x;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-123));
        System.out.println(Integer.MIN_VALUE);
    }
}
