package String;

public class removeSpace {
    public String removeSpaces(String input) {
        if (input == null) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        int count = 0;
        int fast = 0;
        while (fast < input.length()) {
            if (input.charAt(fast) == (" ").charAt(0)) {
                fast++;
            } else {
                if (count > 0) {
                    result.append(" ");
                }
                while (fast < input.length() && input.charAt(fast) != (" ").charAt(0)) {
                    result.append(input.charAt(fast));
                    fast++;
                }
                count++;
            }
        }
        return result.toString();
    }
}
