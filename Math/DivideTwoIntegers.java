//数操作问题
//1.+ - 正负 int sign = 1
//2.越界 long
//3. 0   0为除数java为自动报错
//4. 正常

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0)
            sign = -1;



        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        if (ldividend == 0 || ldividend < ldivisor)
            return 0;
        long res = help(ldividend, ldivisor);

        if(res>Integer.MAX_VALUE)
        {
            if(sign>0)
                return  Integer.MAX_VALUE;
            else
                return  Integer.MIN_VALUE;
        }

        return (int)(res*sign);

    }

    private long help(long ldividend, long ldivisor) {

        if (ldividend < ldivisor)
            return 0;

        long i = ldivisor;
        long j = 1;

        while (i + i <= ldividend) {
            i += i;
            j += j;
        }

        return j + help(ldividend - i, ldivisor);
    }

    public static void main(String[] args) {
        DivideTwoIntegers dt = new DivideTwoIntegers();
        System.out.println(dt.divide(-1,1));
    }
}
