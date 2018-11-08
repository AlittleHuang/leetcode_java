import solutions.Solution29;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        System.out.println(new Solution29().divide(Integer.MIN_VALUE, 1));
    }

    private static void test(int length) {
        long[] values = new long[length];
        int[] counts = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            values[i] = random.nextInt();
            counts[i] = random.nextInt(12);
        }
        int i = 0;
        long l = System.currentTimeMillis();
        for (int i1 = 0; i1 < length; i1++) {
            int count = counts[i];
            long val = values[i];
            i += (((1L << count) & val) >> count);
        }
        System.out.println("time:" + (System.currentTimeMillis() - l));
        System.out.println(i);
        i = 0;

        for (int i1 = 0; i1 < length; i1++) {
            int count = counts[i];
            long val = values[i];
            i += (val >> count) & 1;
        }
        System.out.println("time:" + (System.currentTimeMillis() - l));
        System.out.println(i);
    }
}
