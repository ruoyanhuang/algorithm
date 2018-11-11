package String;

public class deDupTwo {
    public String deDup(String input) {
        if (input == null || input.length() == 0) {
            return "";
        }
        if (input.length() == 1) {
            return input;
        }
        int fast = 1;
        int slow = 0;
        StringBuilder dedup = new StringBuilder();
        dedup.append(input.charAt(slow));
        while (fast < input.length()) {
            if (dedup.length() !=0 && input.charAt(fast) == dedup.charAt(slow)) {
                while (fast < input.length() && input.charAt(fast) == dedup.charAt(slow)) {
                    fast++;
                }
                dedup.deleteCharAt(slow);
                if (slow > 0) {
                    slow--;
                }
            } else {
                dedup.append(input.charAt(fast));
                slow = dedup.length() - 1;
                fast++;
            }
        }
        return dedup.toString();
    }



}
