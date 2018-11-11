package String;

public class deDup {
    public String deDup(String input) {
        if (input == null || input.length() == 0) {
            return "";
        }
        int fast = 1;
        int slow = 0;
        StringBuilder result = new StringBuilder();
        result.append(input.charAt(slow));
        while (fast < input.length()) {
            if (input.charAt(fast) != result.charAt(slow)) {
                result.append(input.charAt(fast));
                slow++;
            }
            fast++;
        }
        return result.toString();
    }
}
