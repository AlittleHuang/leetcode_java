package solutions;

public class Solution7 {

    public static void main(String[] args) {
        System.out.println(new Solution7().reverse(123778));
    }


    public int reverse(int x) {
        int in = x;
        long out = 0;
        while (in != 0) {
            out *= 10;
            out += in % 10;
            in /= 10;
        }
        return out > Integer.MAX_VALUE || out < Integer.MIN_VALUE ? 0 : (int) out;
    }


}
