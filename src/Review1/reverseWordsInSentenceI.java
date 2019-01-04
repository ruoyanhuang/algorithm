package Review1;

public class reverseWordsInSentenceI {
    public String reverseWords(String input) {
        if (input == null) {
            return input;
        }
        char[] array = input.toCharArray();
        reverse(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            int j = i;
            while (j < array.length && array[j] != ' ') {
                j++;
            }
            reverse(array, i, j - 1);
            i = j;                          //i++ in for loop
        }
        return new String(array);
    }

    private void reverse(char[] array, int left, int right) {
        while (left < right) {
            swap(array, left++, right--);
        }
    }

    private void swap(char[] array, int left, int right) {
        char tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
}
