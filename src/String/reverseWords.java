package String;

public class reverseWords {
    public String reverseWords(String input) {
        if (input == null || input.length() == 0) {
            return "";
        }
        char[] array = input.toCharArray();
        array = reverse(array);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (array[i] !=  (" ").charAt(0)) {
                StringBuilder sb = new StringBuilder();
                while (i < array.length && array[i] !=  (" ").charAt(0)) {
                    sb.append(array[i]);
                    i++;
                }
                char[] tmp = reverse(sb.toString().toCharArray());
                res.append(tmp);
            } else {
                res.append(" ");
            }
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    public char[] reverse(char[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            char tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
        return array;
    }
}
