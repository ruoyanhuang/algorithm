import DFS.Restore;

import java.util.Arrays;
import java.util.List;

class test {
//    public static void main(String[] args) {
//        BSClosest test1 = new BSClosest();
//        System.out.println(test1.closest(new int[]{1,2,3,4,4,5,7,8,9}, 6));
//    }
//    public static void main(String[] args) {
//        insert test1 = new insert();
//        System.out.println(test1.searchInsert(new int[]{2,5,7}, 7));
//    }
//    public static void main(String[] args) {
//        fibonacci test1 = new fibonacci();
//        System.out.println(test1.fibonacci(50));
//    }
//    public static void main(String[] args) {
//        power test1 = new power();
//        System.out.println(test1.power(-2, 5));
//    }
//    public static void main(String[] args) {
//        selection test1 = new selection();
//        System.out.println(test1.solve(new int[] {1}));
//    }
//    public static void main(String[] args) {
//        merge test1 = new merge();
//        int[] result = test1.mergeSort(new int[] {3,2,1});
//        for (int i = 0; i < result.length; i++) {
//            System.out.println(result[i]);
//        }
//    }
//    public static void main(String[] args) {
//        quick test1 = new quick();
//        int[] result = test1.quickSort(new int[] {3,5,1,2,4,8});
//        System.out.println(Arrays.toString(result));
//    }
//    public static void main(String[] args) {
//        movezero test1 = new movezero();
//        int[] result = test1.moveZero(new int[] {0,0,1,1,0,1,0});
//        for (int i = 0; i < result.length; i++) {
//            System.out.println(result[i]);
//        }
//    }
//    public static void main(String[] args) {
//        rainbow test1 = new rainbow();
//        int[] result = test1.rainbowSort(new int[] {-1,-1,0,-1,0,1,-1});
//        for (int i = 0; i < result.length; i++) {
//            System.out.println(result[i]);
//        }
//    }
//    public static void main(String[] args) {
//        missingNumber test1 = new missingNumber();
//        int result = test1.missing(new int[] {12,11,10,9,4,5,6,7,2,3,8});
//        System.out.println(result);
//    }
//    public static void main(String[] args) {
//        commonNumber test1 = new commonNumber();
//        ArrayList<Integer> A = new
//        int result = test1.common(new ArrayList<> {12,11,10,9,4,5,6,7,2,3,8}, new int[] {12,11,10,9,4,5,6,7,2,3,8});
//        System.out.println(result);
//    }
//    public static void main(String[] args) {
//        deDupTwo test1 = new deDupTwo();
//        String result = test1.deDup("abba");
//        System.out.println(result);
//    }
//    public static void main(String[] args) {
//        decodeString test1 = new decodeString();
//        String result = test1.decodeString("3[a2[c]]");
//        System.out.println(result);
//    }
//    public static void main(String[] args) {
//        mostCommonWord test1 = new mostCommonWord();
//        String[] banned = new String[]{"hit"};
//        String result = test1.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit. Bob hit a ball, the hit BALL flew far after it was hit. Bob hit a ball, the hit BALL flew far after it was hit. Bob hit a ball, the hit BALL flew far after it was hit. Bob hit a ball, the hit BALL flew far after it was hit. Bob hit a ball, the hit BALL flew far after it was hit. Bob hit a ball, the hit BALL flew far after it was hit. Bob hit a ball, the hit BALL flew far after it was hit. Bob hit a ball, the hit BALL flew far after it was hit. Bob hit a ball, the hit BALL flew far after it was hit. Bob hit a ball, the hit BALL flew far after it was hit. Bob hit a ball, the hit BALL flew far after it was hit. Bob hit a ball, the hit BALL flew far after it was hit. Bob hit a ball, the hit BALL flew far after it was hit. Bob hit a ball, the hit BALL flew far after it was hit. ", banned);
//        System.out.println(result);
//    }
//    public static void main(String[] args) {
//        hotel test1 = new hotel();
//        List<Integer> result = test1.hotel(new int[]{50, 100, 150, 200, 250, 300});
//        System.out.println(result);
//    }
//    public static void main(String[] args) {
//        longest test1 = new longest();
//        String result = test1.longest("abcde", "cbabdfe");
//        System.out.println(result);
//    }
//    public static void main(String[] args) {
//        expression test1 = new expression();
//        double result = test1.largestexpression(new double[]{-2, -3, -4, -5});
//        System.out.println(result);
//    }
//    public static void main(String[] args) {
//        gametheory test1 = new gametheory();
//        int result = test1.greedystrategy(new int[]{5, 2, 1, 4, 3});
//        System.out.println(result);
//    }
    public static void main(String[] args) {
        Restore test1 = new Restore();
        List<String> result = test1.restore("25525511135");
        System.out.println(Arrays.toString(result.toArray()));
    }


}