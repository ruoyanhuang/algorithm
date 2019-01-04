package Review1;

import java.util.ArrayList;
import java.util.List;

public class commonNumbersOfTwoSortedArrays {
    public List<Integer> common(List<Integer> A, List<Integer> B) {
        List<Integer> res = new ArrayList<>();
        if (A.size() == 0 || B.size() == 0) {
            return res;
        }
        int a = 0;
        int b = 0;
        while (a < A.size() && b < B.size()) {
            if (A.get(a) == B.get(b)) {
                res.add(A.get(a));
                a++;
                b++;
            } else if (A.get(a) < B.get(b)) {
                a++;
            } else {
                b++;
            }
        }
        return res;
    }
}
