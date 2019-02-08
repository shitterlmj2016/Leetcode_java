/**
 * This is a comment!
 *
 * @class: SumofEvenNumbersAfterQueries
 * @description: Sum of Even Numbers After Queries
 * @author: Xincheng Huang - xinchenh
 * @create: 02-07-2019 21:41
 **/
public class SumofEvenNumbersAfterQueries {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        if (queries.length == 0 || A.length == 0)
            return null;
        int[] res = new int[queries.length];
        int sum = 0;
        for (int j = 0; j < A.length; j++) {
            if (isEven(A[j]))
                sum += A[j];
        }
        int index = 0;
        //ji+ji ou+ou ou+ji
        for (int i = 0; i < queries.length; i++) {

            if (isEven(A[queries[i][1]]) && isEven(queries[i][0])) {
                sum += queries[i][0];
            } else if (isEven(A[queries[i][1]]) && !isEven(queries[i][0])) {
                sum -= A[queries[i][1]];
            } else if (!(isEven(A[queries[i][1]]) || isEven(queries[i][0]))) {
                sum = sum + A[queries[i][1]] + queries[i][0];
            }
            res[index] = sum;
            A[queries[i][1]] += queries[i][0];
            index++;
        }
        return res;
    }

    private boolean isEven(int i) {
        return i % 2 == 0;
    }
}
