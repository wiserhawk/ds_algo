package datastructures.graphs.dfs_bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://takeuforward.org/graph/g-30-word-ladder-ii

public class WordLadder_2 {


    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();

        List<String> sequence = new ArrayList<>();
        sequence.add(beginWord);
        Pair pair = new Pair(beginWord, sequence);
        queue.add(pair);
        //result.add(pair);
        return bfs(endWord, wordList, queue, result);
    }

    private static List<List<String>> bfs(String endWord, List<String> wordList, Queue<Pair> queue, List<List<String>> result) {
        int length = endWord.length();
        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            String startWord = pair.word;
            List<String> sequence = pair.sequence;
            if (startWord.equals(endWord)) {
                result.add(sequence);
                //return result;
            }
            for (int i = 0; i < length; i++) { 
                String word = startWord;
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] chars = word.toCharArray();
                    chars[i] = ch;
                    String nextWord = String.valueOf(chars);
                    if (wordList.contains(nextWord)) {
                        List<String> newSequence = createNextSequence(sequence, nextWord);
                        //result.add(newSequence);
                        wordList.remove(nextWord);
                        queue.add(new Pair(nextWord, newSequence));
                    }
                }
            }
        }
        return result;
    }

    private static List<String> createNextSequence(List<String> sequence, String word) {
        List<String> newSequence = new ArrayList<>(sequence);
        newSequence.add(word);
        return newSequence;

    }

    public static class Pair {
        public String word;
        public List<String> sequence;
        
        public Pair(String word, List<String> sequence) {
            this.word = word;
            this.sequence = sequence;
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

        List<List<String>> sequences = findLadders(beginWord, endWord, wordList);
        System.out.println("Sequences = " + sequences);
    }
}
