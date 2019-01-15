package LeetCode.Company.GoldmanSachs;

public class stringDistance {
    public double wordsDistance(String s, String word1, String word2) {
        int left = 0;
        int right = 0;
        double leftCenter = -1;
        double rightCenter = s.length();
        double min = -1;
        while (left <= s.length() - word1.length() && right <= s.length() - word2.length()) {
            if (word1.equals(s.substring(left, left + word1.length()))) {
                leftCenter = left + word1.length() / 2.0;
            }
            if (word2.equals(s.substring(right, right + word2.length()))) {
                rightCenter = right + word2.length() / 2.0;
            }
            left++;
            right++;
            if (leftCenter != -1 && rightCenter != s.length()) {
                min = Math.min(min, Math.abs(leftCenter - rightCenter));
            }
        }
        return min;
    }
}
