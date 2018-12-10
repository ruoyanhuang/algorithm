package Bit;

public class hex {
    public String hex(int number) {
        if (number == 0) {
            return "0x0";
        }
        StringBuilder sb = new StringBuilder();
        while (number > 0) {
            int digit = number % 16;
            if (digit < 10) {
                sb.append(digit);
            }else {
                sb.append((char) (digit - 10 + 'A'));
            }
            number = number / 16;
        }
        sb.append("x0");
        return sb.reverse().toString();
    }
}
