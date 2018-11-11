package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class commonNumber {
    public List<Integer> common(List<Integer> A, List<Integer> B) {
        if (A == null || B == null || A.size() == 0 || B.size() == 0) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        int left = 0;
        int right = 0;
        while (left < A.size() && right < B.size()) {
            if (B.get(right) == A.get(left)) {
                result.add(B.get(right));
                left++;
                right++;
            } else if (B.get(right) < A.get(left)) {
                right++;
            } else {
                left++;
            }
        }
        return result;
//        HashMap<Integer, Integer> ANumber = new HashMap<Integer, Integer>();
//        for (int i = 0; i < A.size(); i++) {
//            ANumber.put(i, A.get(i));
//        }
//        for (int j = 0; j < B.size(); j++) {
//            if (ANumber.containsValue(B.get(j))) {
//                result.add(B.get(j));
//                ANumber.remove(B.get(j));
//            }
//        }
//        return result;
    }
}
