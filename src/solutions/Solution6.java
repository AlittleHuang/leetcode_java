package solutions;

public class Solution6 {

    public static void main(String[] args) {
        int[] a = {1, 2};
        System.out.println(new Solution6().convert("PAYPALISHIRING", 1));
    }

    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows <= 1) return s;
        int w = s.length();
        char[][] rows = new char[numRows][w];
        int[] lengths = new int[numRows];
        for (int row = 0, i = 0, path = -1; i < s.length(); i++, row += path) {
            char c = s.charAt(i);
            rows[row][lengths[row]++] = c;
            if (row == rows.length - 1 || row == 0) {
                path = -path;
            }
        }
        char[] chars = new char[s.length()];
        int k = 0;
        for (int i = 0; i < lengths.length; i++) {
            for (int j = 0; j < lengths[i]; j++) {
                chars[k++] = rows[i][j];
            }
        }
        return new String(chars);
    }


}
