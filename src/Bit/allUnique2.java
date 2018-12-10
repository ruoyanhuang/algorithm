package Bit;

public class allUnique2 {
    public boolean allUnique(String word) {
        int[] unique = new int[8];
        for (int i = 0; i < word.length(); i++) {
            int row = word.charAt(i) / 32;
            int col = word.charAt(i) % 32;
            if (((unique[row] >> col) & 1) == 0) {
                unique[row] = unique[row] | (1 << col);
            } else {
                return false;
            }
        }
        return true;
    }
}
