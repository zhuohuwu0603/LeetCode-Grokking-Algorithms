import java.util.*;

// https://leetcode-cn.com/problems/word-ladder/description/
public class Solution2 {

    // 在执行完 LeetCode 所有的测试用例中，的解法 1 用时：562 ms，解法 2 用时： 93 ms。
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (set.contains(beginWord)) {
            set.remove(beginWord);
        }
        Queue<String> queue = new LinkedList<>();

        int level = 1;
        int curNum = 1;
        int nextNum = 0;
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            curNum--;
            for (int i = 0; i < word.length(); i++) {
                char[] wordUnit = word.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    wordUnit[i] = j;
                    String temp = new String(wordUnit);
                    if (set.contains(temp)) {
                        if (temp.equals(endWord)) {
                            return level + 1;
                        }
                        nextNum++;
                        queue.offer(temp);
                        set.remove(temp);
                    }
                }
            }
            if (curNum == 0) {
                curNum = nextNum;
                nextNum = 0;
                level++;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        for (String word : words) {
            wordList.add(word);
        }
        Solution2 solution = new Solution2();

        String beginWord = "hit";
        String endWord = "cog";
        int ladderLength = solution.ladderLength(beginWord, endWord, wordList);
        System.out.println(String.format("从 %s 到 %s 的最短转换序列的长度：%d。", beginWord, endWord, ladderLength));
    }
}
