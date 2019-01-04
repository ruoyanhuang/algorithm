package Review1;

public class removeSpaces {
    public String removeSpaces(String input) {
        char[] array = input.toCharArray();
        int slow = 0;
        int fast = 0;
        while (fast < array.length) {
            if (array[fast] == ' ' && (fast == 0 || array[fast] == array[fast - 1])) {
                fast++;
            } else {
                array[slow++] = array[fast++];
            }
        }
        if (slow == 0) {
            return "";
        } else if (array[slow - 1] == ' ') {
            return new String(array, 0, slow - 1);
        } else {
            return new String(array, 0, slow);
        }
    }
}
