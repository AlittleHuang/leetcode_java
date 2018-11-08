package solutions;

import java.util.Random;

public class Solution862 {


    private static final Solution862 SOLUTION = new Solution862();

    public static void main(String[] args) {
        int tmp = 0;
        int x = (tmp += 1);
        System.out.println(x);
        //[-28,81,-20,28,-29]
        //89
        int[] a = {-28, 81, -20, 28, -29};
        int k = 89;
        System.out.println(SOLUTION.shortestSubarray(a, k));
        test();
    }


    public int shortestSubarray(int[] A, int K) {
        int length = A.length;
        int[] sumTo0 = new int[length];
        int result = length;

        int sum = 0, min = A[0], max = A[0], maxIndex = 0, minIndex = 0;

        for (int hi = 0; hi < A.length; hi++) {
            if (A[hi] >= K) return 1;
            sumTo0[hi] = sum;
            if (sum > min) {
                min = sum;
                maxIndex = hi;
            } else if (sum < max) {
                max = sum;
                minIndex = hi;
            }

            if (max - sum >= K) {
                for (int lo = maxIndex; lo < hi; lo++) {

                }
            }
            if (sum - min >= K) {

            }

        }


        return result;
    }

    private static void test() {
        int length = 100000;
        int[] A = new int[length];
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < length; j++) {
                A[j] = random.nextInt(1000000) - 500000;
            }
            long time = System.currentTimeMillis();
            int result = SOLUTION.shortestSubarray(A, 10000000);
            System.out.println(result + "-->time:" + (System.currentTimeMillis() - time));

        }
    }


}
