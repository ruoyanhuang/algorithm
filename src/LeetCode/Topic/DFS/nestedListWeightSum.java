//package LeetCode.Topic.DFS;
//
//import java.util.List;
//
//interface NestedInteger {
//     public NestedInteger();
//
//     public NestedInteger(int value);
//
//     public boolean isInteger();
//
//     public Integer getInteger();
//
//     public void setInteger(int value);
//
//     public void add(NestedInteger ni);
//
//     public List<NestedInteger> getList();
// }
//
//public class nestedListWeightSum {
//    public int depthSum(List<NestedInteger> nestedList) {
//        return recursion(nestedList, 1);
//    }
//
//    public int recursion(List<NestedInteger> nestedList, int level) {
//        int sum = 0;
//        for (NestedInteger ni : nestedList) {
//            if (ni.isInteger()) {
//                sum += level * ni.getInteger();
//            } else {
//                sum += recursion(ni.getList(), level + 1);
//            }
//        }
//        return sum;
//    }
//}
