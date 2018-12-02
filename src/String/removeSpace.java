package String;

public class removeSpace {
    public String removeSpaces(String input) {
        if (input == null || input.length() == 0) {
            return "";
        }
        char[] target = input.toCharArray();
        int slow = 0;
        int fast = 0;
        char space = (" ").charAt(0);
        while (fast < target.length) {
            if (fast == 0 && target[fast] == space) {
                while (target[fast] == space && fast < target.length) {
                    fast++;
                }
                if (fast >= target.length) {
                    return "";
                }
            }
            if (target[fast] != space) {
                target[slow] = target[fast];
                slow++;
                fast++;
            } else {
                target[slow] = space;
                slow++;
                while (target[fast] == space && fast < target.length) {
                    fast++;
                }
            }
        }
        if (target[slow - 1] == space) {
            slow--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < slow; i++) {
            sb.append(target[i]);
        }
        return sb.toString();
    }
}
