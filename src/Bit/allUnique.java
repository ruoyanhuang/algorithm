package Bit;

public class allUnique {
    public boolean allUnique(String word) {
        int unique = 0;
        for (int i = 0; i < word.length(); i++) {
            int digit = word.charAt(i) - 'a';
            if (((unique >> digit) & 1) == 0) {
                unique = unique & (1 << digit);
            } else {
                return  false;
            }
        }
        return true;
    }
}
