package LeetCode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

class dict {
    public String word;
    public int freq;
    public dict(String word, int freq) {
        this.word = word;
        this.freq = freq;
    }
}

class freqComparator implements Comparator<dict> {
    @Override
    public int compare(dict d1, dict d2) {
        if (d1.freq <= d2.freq) {
            return 1;
        } else {
            return -1;
        }
    }
}

public class mostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String, Integer> words = new HashMap<>();
        HashSet<String> ban = new HashSet<>();
        for (int i = 0; i < paragraph.length(); i++) {              //Time complexity O(n)
            if (isCharacter(paragraph.charAt(i))) {                 //Space complexity O(n)
                StringBuilder newword = new StringBuilder();
                while (i < paragraph.length() && isCharacter(paragraph.charAt(i))) {
                    newword.append(paragraph.charAt(i));
                    i++;
                }
                i--;
                if (words.containsKey(lowerCase(newword))) {
                    words.put(lowerCase(newword), words.get(lowerCase(newword)) + 1);
                } else {
                    words.put(lowerCase(newword), 1);
                }
            }
        }
        PriorityQueue<dict> dictionary = new PriorityQueue<>(words.size(), new freqComparator());
        for (HashMap.Entry<String, Integer> entry : words.entrySet()) {
            dictionary.add(new dict(entry.getKey(), entry.getValue()));
        }
        for (int i = 0; i < banned.length; i++) {
            ban.add(banned[i]);
        }
        while (dictionary.size() != 0) {
            String result = dictionary.remove().word;
            if (!ban.contains(result)) {
                return result;
            }
        }
        return null;
    }

    public boolean isCharacter(Character a) {
        if (a == null) {
            return false;
        }
        return a - 'a' >= 0 && a - 'a' <= 25 || a - 'A' >= 0 && a - 'A' <= 25;
    }

    public String lowerCase(StringBuilder sb) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) - 'a' >= 0 && sb.charAt(i) - 'a' <= 25) {
                res.append(sb.charAt(i));
            } else {
                res.append((char) (sb.charAt(i) + 32));
            }
        }
        return res.toString();
    }
}

