package String;

public class deDupTwo {
    public String deDup(String input) {
        if (input == null || input.length() == 0) {
            return "";
        }
        int fast = 1;
        int slow = 0;
        StringBuilder dedup = new StringBuilder();
        StringBuilder result = new StringBuilder();
        result.append(input.charAt(slow));
        while (fast < input.length()) {
            if (slow >=0 && input.charAt(fast) == result.charAt(slow)) {
                while (input.charAt(fast) == result.charAt(slow)) {
                    fast++;
                }
                slow--;
            } else {
                if (slow < 0){
                    slow = 0;
                }
                result.append(input.charAt(fast));
                fast++;
                slow++;
            }
        }
        for (int i = 0; i <= slow; i++) {
            dedup.append(result.charAt(i));
        }
        return dedup.toString();
    }


    
}
