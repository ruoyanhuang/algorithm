package Review1;

public class removeAdjacentRepeatedCharactersI {
    public String deDup(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }
        char[] array = input.toCharArray();
        int slow = 0;
        int fast = 0;
        while (fast <input.length()) {
            if (array[fast] != array[slow]) {
                array[++slow] = array[fast];
            }
            fast++;
        }
        return new String(array, 0, slow + 1);
    }
}
