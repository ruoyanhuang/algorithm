package LeetCode.Company.Amazon;

public class Zuma {
    public int[] removeSame(int[] input) {
        if (input == null || input.length <= 2) {
            return input;
        }
        int slow = -1;
        int fast = 0;
        while (fast < input.length) {
            if (slow == -1 || slow == 0 || input[slow] != input[fast] || input[slow] != input[slow - 1]) {
                input[++slow] = input[fast++];
            } else {
                while (fast < input.length && input[fast] == input[slow]) {
                    fast++;
                }
                while (slow > 0 && input[slow] == input[slow - 1]) {
                    slow--;
                }
                if (input[slow] == input[slow + 1]) {
                    slow--;
                }
            }
        }
        if (slow == -1) {
            return new int[0];
        } else {
            int[] res = new int[slow + 1];
            for (int i = 0; i <= slow; i++) {
                res[i] = input[i];
            }
            return res;
        }
    }
}
