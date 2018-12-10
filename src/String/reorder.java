package String;

public class reorder {
    public int[] reorder(int[] array) {
        int left = 0;
        int right = array.length % 2 == 0 ? array.length - 1 : array.length - 2;
        helper(array, left, right);
        return array;
    }

//    public void helper(int[] array, int left, int right) {
//        if (left >= right) {
//            return;
//        }
//        int length = right - left + 1;
//        int mid = left + length / 2;
//        int lm = left + length / 4;
//        int rm = left + length * 3 / 4;
//        reverse(array, lm, rm - 1);
//        reverse(array, lm, mid - 1);
//        reverse(array, mid, rm - 1);
//        helper(array, left, left + length / 2 - 1);
//        helper(array, left + length / 2, right);
//    }

    public void helper(int[] array, int left, int right) {
        int length = right - left + 1;
        if (length <= 2) {
            return;
        }
        int mid = left + length / 2;
        int lmid = left + length / 4;
        int rmid = left + length * 3 / 4;
        reverse(array, lmid, mid - 1);
        reverse(array, mid, rmid - 1);
        reverse(array, lmid, rmid - 1);                     //cannot reverse the order if length is odd
        helper(array, left, left + (lmid - left) * 2 - 1);
        helper(array, left + (lmid - left) * 2, right);
    }

    public void reverse(int[] array, int left, int right) {
        while (left < right) {
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
    }
}
