package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {
    class TrieNode {
        TrieNode[] map;
        Boolean isWord;
        Integer count;
        String word;
        public TrieNode () {
            this.map = new TrieNode[26];
            this.isWord = false;
            this.count = 0;
            this.word = null;
        }
    }

    private TrieNode root = new TrieNode();

    private static int[][] directions = new int[][] {
            new int[] {1, 0},
            new int[] {-1, 0},
            new int[] {0, 1},
            new int[] {0, -1},
    };

    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words) {
            insert(word);
        }
        List<String> res  = new ArrayList<>();
        Set<String> curRes = new HashSet<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, visited, i, j, root, curRes, res);
            }
        }
        return res;
    }

    private void dfs (char[][] board, boolean[][] visited, int x, int y, TrieNode node, Set<String> curRes, List<String> res) {
        if (!checkBoundary(x, y, board.length, board[0].length) || visited[x][y] || node.map[board[x][y] - 'a'] == null) {
            return;
        }
        TrieNode nextNode = node.map[board[x][y] - 'a'];
        visited[x][y] = true;
        if (nextNode.isWord && curRes.add(nextNode.word)) {
            res.add(nextNode.word);
            if (node.count == 0) {
//                for (int i = 0; i < board.length; i++) {
//                    for (int j = 0; j < board[0].length; j++) {
//                        dfs(board, new boolean[board.length][board[0].length], i, j, root, curRes, res);
//                    }
//                }
                visited[x][y] = false;
                return;
            }
//            curRes.remove(nextNode.word);

        }
        for (int[] direction : directions) {
            dfs(board, visited, x + direction[0], y + direction[1], nextNode, curRes, res);
        }
        visited[x][y] = false;
    }

    private boolean checkBoundary(int x, int y, int row, int col) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }

    private void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.map[ch - 'a'] == null) {
                node.map[ch - 'a'] = new TrieNode();
            }
            node = node.map[ch - 'a'];
            node.count += 1;
        }
        node.isWord = true;
        node.word = word;
        node.count -= 1;
    }
}
