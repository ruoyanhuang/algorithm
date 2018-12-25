package LeetCode.Company.FaceBook;

public class addTwoBinary {
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }
        StringBuilder sb = new StringBuilder();
        int a1 = a.length() - 1;
        int b1 = b.length() - 1;
        int add = 0;
        while (a1 >= 0 && b1 >= 0) {
            int res = a.charAt(a1) - '0' + b.charAt(b1) - '0' + add;
            if (res > 1) {
                res = res % 2;
                add = 1;
            } else {
                add = 0;
            }
            sb.append(res);
            a1--;
            b1--;
        }
        while (a1 >= 0) {
            int res = a.charAt(a1) - '0' + add;
            if (res > 1) {
                res = res % 2;
                add = 1;
            } else {
                add = 0;
            }
            sb.append(res);
            a1--;
        }
        while (b1 >= 0) {
            int res = b.charAt(b1) - '0' + add;
            if (res > 1) {
                res = res % 2;
                add = 1;
            } else {
                add = 0;
            }
            sb.append(res);
            b1--;
        }
        if (add == 1) {
            sb.append("1");
        }
        return sb.reverse().toString();
    }
}
