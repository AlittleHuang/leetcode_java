package solutions;

public class Solution862 {

    public int shortestSubarray(int[] A, int K) {

        int[] sums = new int[A.length];
        sums[0] = A[0];
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + A[i];
        }

        int[] loIndexs = new int[sums.length];//
        int loLength = 0;
        int shortest = A.length + 1;

        for (int ilo = 0, hi = 0; hi < sums.length; hi++) {
            for (; ilo < loLength && sums[hi] - sums[loIndexs[ilo]] >= K; ilo++) {
                shortest = Math.min(shortest, hi - loIndexs[ilo]);
            }
            for (; ilo < loLength && sums[loIndexs[loLength - 1]] >= sums[hi]; loLength--) ;
            loIndexs[loLength++] = hi;
        }
        return shortest > A.length ? -1 : shortest;

    }


}
