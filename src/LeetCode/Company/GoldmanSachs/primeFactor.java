package LeetCode.Company.GoldmanSachs;

import java.util.ArrayList;
import java.util.List;

public class primeFactor {
//    public List<Integer> findPrimeFactor(int num) {
//        List<Integer> res = new ArrayList<>();
//        helper(num, res);
//        return res;
//    }
//
//    private void helper(int num, List<Integer> res) {
//        if (num == 1) {
//            return;
//        }
//        for (int i = 2; i <= num; i++) {
//            if (num % i == 0) {
//                res.add(i);
//                helper(num / i, res);
//                break;
//            }
//        }
//    }

    public List<Integer> findPrimeFactor(int num) {
        List<Integer> res = new ArrayList<>();
        for (int i = 2; i <= num; i++) {
            while (num % i == 0) {
                res.add(i);
                num = num / i;
            }
        }
        return res;
    }
}
