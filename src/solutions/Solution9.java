package solutions;

public class Solution9 {

    public static void main(String[] args) {
        System.out.println(new Solution9().isPalindrome(11));
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || x % 10 == 0) return false;
        if (x < 10) return true;

        int out = 0;
        for (; x > out; x /= 10) {
            out = out * 10 + x % 10;
        }

        return out == x || x == out / 10;
    }

}
