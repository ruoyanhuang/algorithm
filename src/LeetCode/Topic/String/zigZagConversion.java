package LeetCode.Topic.String;

public class zigZagConversion {
    public String convert(String s, int numRows) {
        if (s == null || numRows <= 1) {
            return s;
        }
        StringBuilder[] array = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            array[i] = new StringBuilder();
        }
        for (int i = 0; i < s.length(); i++) {
            int position = i % (2 * (numRows - 1));
            if (position < numRows - 1) {
                array[position].append(s.charAt(i));
            } else {
                array[2 * (numRows - 1) - position].append(s.charAt(i));
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            res.append(array[i]);
        }
        return res.toString();
    }
}
