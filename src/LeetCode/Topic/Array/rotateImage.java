package LeetCode.Topic.Array;

public class rotateImage {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length <= 1) {
            return;
        }
        int level = (matrix.length + 1) / 2;
        for (int i = 0; i < level; i++) {
            if (i == level && matrix.length % 2 == 1) {
                return;
            }
            int end = matrix.length - 1 - i;
            for (int j = i; j < end; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[end - j + i][i];
                matrix[end - j + i][i] = matrix[end][end - j + i];
                matrix[end][end - j + i] = matrix[j][end];
                matrix[j][end] = tmp;
            }
        }
    }
}
