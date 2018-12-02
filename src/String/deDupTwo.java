package String;

public class deDupTwo {
    public String deDup(String input) {
        if (input == null || input.length() <= 0) {
            return input;
        }
        int fast = 1;
        int slow = 0;
        char[] dedup = input.toCharArray();
        while (fast < dedup.length) {
            if (slow < 0 || dedup[fast] != dedup[slow]) {
                slow++;
                dedup[slow] = dedup[fast];
                fast++;
            } else {
                while (fast < dedup.length && dedup[fast] == dedup[slow]) {
                    fast++;
                }
                slow--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= slow; i++) {
            sb.append(dedup[i]);
        }
        return sb.toString();
    }



}
