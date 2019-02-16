package LeetCode.Company.Amazon;

import java.util.*;

public class nearestSum {
    class Application{
        int id;
        int value;
        public Application(int id, int value) {
            this.id = id;
            this.value = value;
        }
    }

    public List<List<Application>> findNearest(List<Application> input1, List<Application> input2, int capacity) {
        List<List<Application>> res = new ArrayList<>();
        if (input1 == null || input1.size() == 0) {
            return res;
        }
        int globalMax = 0;
        Collections.sort(input1, new Comparator<Application>() {
            @Override
            public int compare(Application o1, Application o2) {
                if (o1.value < o2.value) {
                    return -1;
                } else if (o1.value == o2.value) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        Collections.sort(input2, new Comparator<Application>() {
            @Override
            public int compare(Application o1, Application o2) {
                if (o1.value < o2.value) {
                    return -1;
                } else if (o1.value == o2.value) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        for (int i = 0; i < input1.size(); i++) {
            if (input1.get(i).value > capacity) {
                break;
            }
            int tmp = capacity - input1.get(i).value;
            int index2 = largestSmall(input2, tmp);
            if (index2 == -1 || input2.get(index2).value + input1.get(i).value < globalMax) {
                continue;
            }  else if (input2.get(index2).value + input1.get(i).value > globalMax) {
                globalMax = input2.get(index2).value + input1.get(i).value;
                res = new ArrayList<>();
            }
            int first = firstOccurrence(input2, input2.get(index2).value);
            int last = lastOccurrence(input2, input2.get(index2).value);
            if (first != -1 && last != -1) {
                for (int j = first; j <= last; j++) {
                    List<Application> temp = new ArrayList<>();
                    temp.add(input1.get(i));
                    temp.add(input2.get(j));
                    res.add(temp);
                }
            }
        }
        return res;
    }

    private int largestSmall(List<Application> input2, int target) {
        if (input2 == null || input2.size() == 0 || input2.get(0).value > target) {
            return -1;
        }
        int left = 0;
        int right = input2.size() - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (input2.get(mid).value <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return input2.get(right).value <= target ? right : left;
    }

    private int firstOccurrence(List<Application> input2, int target) {
        if (input2 == null || input2.size() == 0) {
            return -1;
        }
        int left = 0;
        int right = input2.size() - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (input2.get(mid).value < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (input2.get(left).value == target) {
            return left;
        } else if (input2.get(right).value == target) {
            return right;
        } else {
            return -1;
        }
    }

    private int lastOccurrence(List<Application> input2, int target) {
        if (input2 == null || input2.size() == 0) {
            return -1;
        }
        int left = 0;
        int right = input2.size() - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (input2.get(mid).value > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        if (input2.get(right).value == target) {
            return right;
        } else if (input2.get(left).value == target) {
            return left;
        } else {
            return -1;
        }
    }
}
