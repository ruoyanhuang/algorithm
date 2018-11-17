package LeetCode;

import java.util.*;

public class ladderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || beginWord.length() != endWord.length() ||
                beginWord.equals(endWord) || !wordList.contains(endWord)) {
            return 0;
        }
        Set<String> wordDict = new HashSet<>(wordList);
        Queue<String> path = new LinkedList<>();
        path.offer(beginWord);
        int count = 1;
        while (!path.isEmpty()) {
            count++;
            int size = path.size();
            for (int k = 0; k < size; k++) {
                char[] word = path.poll().toCharArray();
                for (int i = 0; i < beginWord.length(); i++) {
                    for (int j = 0; j < 26; j++) {
                        char tmp = word[i];
                        word[i] = (char) ('a' + j);
                        String wordstr = new String(word);
                        if (wordstr.equals(endWord)) {
                            return count;
                        } else if (wordDict.contains(wordstr)) {
                            path.offer(wordstr);
                            wordDict.remove(wordstr);
                        }
                        word[i] = tmp;
                    }
                }
            }
        }
        return 0;
    }

}
