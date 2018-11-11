package solutions;

public class Solution8 {

    public static void main(String[] args) {
        System.out.println(Integer.toString(Integer.MIN_VALUE).length());
        System.out.println(new Solution8().myAtoi("-000000000000042"));
    }

    public int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0) return 0;
        char cStart = str.charAt(0);
        int startOfNo = cStart == '-' || cStart == '+' ? 1 : 0;
        if (startOfNo == str.length()) return 0;
        char fistNum = str.charAt(startOfNo);
        if (fistNum > '9' || fistNum < '0') return 0;

        int maxLength = 11;
        for (int i = startOfNo; i < str.length() && str.charAt(i) == '0'; i++) {
            maxLength++;
        }
        int i = startOfNo;

        int length = Math.min(str.length(), maxLength);

        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c > '9' || c < '0') {
                break;
            }
        }

        String result = str.substring(0, i);
        long value = Long.valueOf(result);
        if (value < Integer.MIN_VALUE) value = Integer.MIN_VALUE;
        if (value > Integer.MAX_VALUE) value = Integer.MAX_VALUE;
        return (int) value;
    }

}
