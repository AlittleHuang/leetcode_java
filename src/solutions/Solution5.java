package solutions;

public class Solution5 {

    public static void main(String[] args) {
        System.out.println(new Solution5().longestPalindrome("12121"));
    }

    int beginIndex = 0;
    int endIndex = 2;

    public String longestPalindrome(String s) {
        int length = s.length();
        if (length == 0) return s;
        int[] chars = new int[length + 2];
        chars[0] = Integer.MIN_VALUE;
        chars[length] = Integer.MAX_VALUE;

        for (int i = 0; i < length; i++) {
            chars[i+1] = s.charAt(i);
        }

        int lo, hi;
        for (int i = 1; i < length; i++) {
            for (lo = i, hi = i; chars[lo] == chars[hi]; lo--, hi++) ;
            initIndex(lo, hi);
            for (lo = i, hi = i + 1; chars[lo] == chars[hi]; lo--, hi++) ;
            initIndex(lo, hi);
        }

        return s.substring(beginIndex, endIndex - 1);

    }

    private void initIndex(int st, int ed) {
        if (endIndex - beginIndex < ed - st) {
            endIndex = ed;
            beginIndex = st;
        }
    }

}
