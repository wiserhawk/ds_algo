package datastructures.graphs.dfs_bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://takeuforward.org/graph/word-ladder-i-g-29/

public class WordLadder_1 {

    public static int findLadders(String beginWord, String endWord, List<String> wordList) {
        List<Pair> result = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        Pair pair = new Pair(beginWord, 1);
        queue.add(pair);
        result.add(pair);
        return bfs(endWord, wordList, queue, result);
    }

    private static int bfs(String endWord, List<String> wordList, Queue<Pair> queue, List<Pair> result) {
        int length = endWord.length();
        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            String startWord = pair.first;
            int level = pair.second;
            if (startWord.equals(endWord)) {
                return level;
            }
            for (int i = 0; i < length; i++) { 
                String word = startWord;
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] chars = word.toCharArray();
                    chars[i] = ch;
                    String nextWord = String.valueOf(chars);
                    if (wordList.contains(nextWord)) {
                        result.add(new Pair(nextWord, level + 1));
                        wordList.remove(nextWord);
                        queue.add(new Pair(nextWord, level + 1));
                    }
                }
            }
        }
        return 0;
    }

    public static class Pair {
        public String first;
        public int second;
        
        public Pair(String first, int second) {
            this.first = first;
            this.second = second;
        }
        @Override
        public String toString() {
            return "[word=" + first + ", level=" + second + "]";
        }
    }


    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        String beginWord = "hit";
        String endWord = "cog";

        int sequence = findLadders(beginWord, endWord, wordList);
        System.out.println("Sequence = " + sequence);
    }


}
