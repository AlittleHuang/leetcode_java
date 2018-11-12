package solutions;

public class Solution862 {

    public static void main(String[] args) {
        int[] a = {1, 2};
        System.out.println(new Solution862().shortestSubarray(a, 4));
    }

    public int shortestSubarray(int[] A, int K) {

        int[] sums = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            sums[i + 1] = sums[i] + A[i];
        }

        int[] loIndexs = new int[sums.length];//list
        int loLength = 0;//loIndexs length
        int shortest = A.length + 1;

        for (int ilo = 0, hi = 0; hi < sums.length; hi++) {
            for (; ilo < loLength && sums[hi] - sums[loIndexs[ilo]] >= K; ilo++) {
                shortest = Math.min(shortest, hi - loIndexs[ilo]);
            }
            while (ilo < loLength && sums[loIndexs[loLength - 1]] >= sums[hi]) {
                loLength--;//pop
            }
            loIndexs[loLength++] = hi;//push
        }
        return shortest > A.length ? -1 : shortest;

    }


}
