package LeetCode;

import entity.TreeNode;
import sun.security.acl.WorldGroupImpl;

import java.util.*;

class WordNode {
    public String word;
    public List<WordNode> neighbor;
    public WordNode(String word) {
        this.word = word;
        this.neighbor = new ArrayList<>();
    }
}

public class ladderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        WordNode start = new WordNode(beginWord);
        WordNode target = new WordNode(endWord);
        HashMap<String, WordNode> path = new HashMap<>();
        path.put(beginWord, start);
        path.put(endWord, target);
        for (String s : wordList) {
            WordNode str = new WordNode(s);
            for (HashMap.Entry<String, WordNode> entry : path.entrySet()) {
                if (isConnected(s, entry.getKey())) {
                    str.neighbor.add(entry.getValue());
                    entry.getValue().neighbor.add(str);
                }
            }
            path.put(s, str);
        }
        int count = 1;
        return bfs(start, target, path, count);
    }

    public boolean isConnected(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int count = 1;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int bfs(WordNode start, WordNode target, HashMap<String, WordNode> path, int count) {
        if (start == target) {
            return count;
        }
        for (HashMap.Entry<String, WordNode> entry : path.entrySet()) {
            bfs(entry.getValue(), target, path, count);
        }
    }
}
