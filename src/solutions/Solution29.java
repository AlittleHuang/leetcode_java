package solutions;

public class Solution29 {

    public static void main(String[] args) {
        System.out.println(new Solution29().divide(Integer.MIN_VALUE, -1109186033));
    }

    public int divide(int dividend, int divisor) {
        if ((dividend == Integer.MIN_VALUE && divisor == -1)) return Integer.MAX_VALUE;

        boolean br = divisor < 0, bd = dividend < 0;
        long dr = br ? -(long) divisor : divisor;
        long dd = bd ? -(long) dividend : dividend;

        long result = 0;
        for (long i = 32, curr = 0; i >= 0; i--) {
            curr <<= 1;
            curr += (((1 << i) & dd) >> i);
            result <<= 1;
            if (curr >= dr) {
                curr -= dr;
                result++;
            }
        }

        return (int) (br ^ bd ? -result : result);
    }

}
