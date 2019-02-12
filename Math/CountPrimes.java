/**
 * This is a comment!
 *
 * @class: CountPrimes
 * @description: count primes
 * @author: Xincheng Huang - xinchenh
 * @create: 02-11-2019 23:29
 **/
public class CountPrimes {

    //Eeatosthese O(sqrt(n))
    //less than
    public int countPrimes(int n) {
        int res = 0;
        boolean notPrime[] = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                res++;
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }
        return res;
    }


}
