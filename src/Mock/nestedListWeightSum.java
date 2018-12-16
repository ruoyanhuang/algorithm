//package Mock;
//
//import java.util.List;
//
//public interface NestedInteger {
//    public NestedInteger();
//
//    public NestedInteger(int value);
//
//    public boolean isInteger();
//
//    public Integer getInteger();
//
//    public void setInteger(int value);
//
//    public void add(NestedInteger ni);
//
//    public List<NestedInteger> getList();
//}
//
//public class nestedListWeightSum {
//    public int depthSumInverse(List<NestedInteger> nestedList) {
//        if (nestedList == null || nestedList.size() == 0) {
//            return 0;
//        }
//        int depth = getDepth(nestedList);
//        return recursion(nestedList, depth);
//    }
//
//    public int recursion(List<NestedInteger> nestedList, int depth) {
//        if (depth == 0) {
//            return 0;
//        }
//        int sum = 0;
//        for (NestedInteger ni : nestedList) {
//            if (ni.isInteger()) {
//                sum += depth * ni.getInteger();
//            } else {
//                sum += recursion(ni.getList(), depth - 1);
//            }
//        }
//        return sum;
//    }
//
//    public int getDepth(List<NestedInteger> list) {
//        if (list == null || list.size() == 0) {
//            return 0;
//        }
//        int level = 1;
//        for (NestedInteger ni : list) {
//            if (!ni.isInteger()) {
//                level = Math.max(level, getDepth(ni.getList()) + 1);
//            }
//        }
//        return level;
//    }
//}
