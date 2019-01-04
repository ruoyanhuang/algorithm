package Review1;

import java.util.ArrayDeque;
import java.util.Deque;

public class removeAdjacentRepeatedCharactersIV {
    public String deDup(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }
        char[] array = input.toCharArray();
        int slow = 0;
        int fast = 1;
        while (fast < array.length) {
            if (slow == -1 || array[fast] != array[slow]) {
                array[++slow] = array[fast++];
            } else {
                while (fast < array.length && array[fast] == array[slow]) {
                    fast++;
                }
                slow--;
                while (slow >= 0 && array[slow] == array[slow + 1]) {
                    slow--;
                }
            }
        }
        if (slow == -1) {
            return "";
        } else {
            return new String(array, 0, slow + 1);
        }
    }
}
