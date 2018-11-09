package solutions;

import java.util.Arrays;
import java.util.Random;

public class Solution862 {


    private static final Solution862 SOLUTION = new Solution862();

    public static void main(String[] args) {
        //[31,63,-38,43,65,74,90,-23,45,22]
        //341
        int[] a = {1, 1, 0, 0, -3, 6, 2, 1, 1, 6};
        int k = 8;
        System.out.println(SOLUTION.shortestSubarray(a, k));
        int[] test = test();
        int result = SOLUTION.shortestSubarray(test, 8);
        System.out.println(result);
    }


    public int shortestSubarray(int[] A, int K) {

        int length = A.length;
        int[] sums = new int[length + 1];
        int[] nexMax = new int[length];
        int shortest = length + 1;

        int right = length;

        for (int left = length - 1; left >= 0; left--) {
            if (A[left] >= K) return 1;
            sums[left] = sums[left + 1] + A[left];
            right = Math.min(length, left + shortest);
            for (; right > left; right--) {
                if (sums[left] - sums[right] >= K) {
                    shortest = right - left;
                }
            }

        }


        return shortest > length ? -1 : shortest;
    }

    private static int[] test() {
        int length = 10;
        int k = 8;
        int[] A = new int[length];
        Random random = new Random();
        for (int i = 0; i < 1000000; i++) {
            for (int j = 0; j < length; j++) {
                A[j] = random.nextInt(10) - 3;
            }
            long time = System.currentTimeMillis();
            int result = 0;
            try {
                result = SOLUTION.shortestSubarray(A, k);
            } catch (Exception e) {
                throw new RuntimeException(Arrays.toString(A), e);
            }
            int demo = SOLUTION.shortestSubarrayDemo(Arrays.copyOf(A, length), k);
            if (result == demo) {
                System.out.print(result + ", "/* + "<-->" + demo + Arrays.toString(A)*/);
            } else {
                System.out.println();
                System.out.println(result + "<-->" + demo + Arrays.toString(A));
                return A;
            }

        }
        return null;
    }

    public int shortestSubarrayDemo(int[] A, int K) {

        if (A == null || A.length == 0) {
            return 0;
        }
        if (Integer.MIN_VALUE == K) {
            return -1;
        }
        if (A.length == 1) {
            return A[0] >= K ? 1 : -1;
        }

        if (K <= 0) {
            for (int i = 0; i < A.length; i++) {
                if (A[i] >= K) {
                    return 1;
                }
            }
            return -1;
        }

        int before = A[0];
        for (int i = 1; i < A.length; i++) {
            before = (A[i] += before);
        }

        int[] indexs = new int[A.length + 1];
        indexs[0] = -1;
        int[] values = new int[A.length + 1];

        int left = 0, right = 0, rRt = -1;
        for (int i = 0; i < A.length; i++) {
            for (; left <= right && A[i] - values[left] >= K; ) {
                if (rRt == -1 || i - indexs[left] < rRt) {
                    rRt = i - indexs[left];
                }
                left += 1;
            }
            for (; left <= right && values[right] >= A[i]; ) {
                right -= 1;
            }
            right += 1;
            indexs[right] = i;
            values[right] = A[i];
        }
        return rRt;
    }


}
