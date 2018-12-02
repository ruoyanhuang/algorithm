package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class findWords {
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> word = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            word.add(words[i]);
        }
        Set<String> res = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                StringBuilder sb = new StringBuilder();
                dfs(i, j, board, visited, word, sb, res);
            }
        }
        List<String> result = new ArrayList<>(res);
        return result;
    }

    public void dfs(int row, int col, char[][] board, boolean[][] visited, Set<String> word, StringBuilder sb, Set<String> res) {
        if (word.contains(sb.toString()) && !res.contains(sb.toString())) {
            res.add(sb.toString());
        }
        visited[row][col] = true;
        if (row < board.length - 1 && !visited[row + 1][col]) {
            sb.append(board[row + 1][col]);
            dfs(row + 1, col, board, visited, word, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (col < board[0].length - 1 && !visited[row][col + 1]) {
            sb.append(board[row][col + 1]);
            dfs(row, col + 1, board, visited, word, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (row > 0 && !visited[row - 1][col]) {
            sb.append(board[row - 1][col]);
            dfs(row + 1, col, board, visited, word, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (col > 0 && !visited[row][col - 1]) {
            sb.append(board[row][col - 1]);
            dfs(row, col - 1, board, visited, word, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
