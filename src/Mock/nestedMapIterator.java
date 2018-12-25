//package Mock;
//
//import java.util.*;
//
//public interface NestedMap {
//    // @return true if this NestedInteger holds a single integer, rather than a nested list.
//    public boolean isInteger();
//
//    // @return the single integer that this NestedInteger holds, if it holds a single integer
//    // Return null if this NestedInteger holds a nested list
//    public Integer getInteger();
//
//    // @return the nested list that this NestedMap holds, if it holds a nested list
//    // Return null if this NestedInteger holds a single integer
//    public NestedMap getMap();
//}
//
//public class NestedIterator implements Iterator<Integer> {
//    Deque<Integer> stack;
//
//    public NestedIterator(NestedMap nestedMap) {
//        stack = new ArrayDeque<>();
//        push(nestedMap, stack);
//    }
//
//    private void push(NestedMap nestedMap, Deque<Integer> stack) {
//        for (Map.Entry entry : nestedMap) {
//            if (entry.getValue().isInteger()) {
//                stack.offerFirst(entry.getValue().getInteger());
//            } else {
//                push(entry.getValue().getMap(), stack);
//            }
//        }
//    }
//
//    @Override
//    public Integer next() {
//
//    }
//
//    @Override
//    public boolean hasNext() {
//        return stack.peekFirst() == null;
//    }
//}