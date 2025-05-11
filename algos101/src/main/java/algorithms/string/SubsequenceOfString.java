package algorithms.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * https://www.geeksforgeeks.org/print-subsequences-string/
 */
public class SubsequenceOfString {

    // public static Set<String> subsequences(String str) {
    //     Set<String> result = new HashSet<>();
    //     int length = str.length();

    //     for (int seqLen=1; seqLen <= length; seqLen++) {
    //         for (int i=0; i<length; i++) {
    //             if (i+seqLen >= length)
    //             String sequence = str.substring(i, i+seqLen);
    //             result.add(sequence);
    //         }
    //     }
    //     return result;
    // }

    public static List<String> findSubsequences(String str) {
        List<String> subsequenceList = new ArrayList<>();
        subsequences(str, "", subsequenceList);
        return subsequenceList;
    }

    public static void subsequences(String str, String subSeq, List<String> subsequenceList) {
        if (str.length() == 0) {
            subsequenceList.add(subSeq);
            return;
        }
        subsequences(str.substring(1), subSeq + str.charAt(0), subsequenceList);
        subsequences(str.substring(1), subSeq, subsequenceList);
    }

    public static void main(String[] args) {
        String str = "geeks";
        List<String> result = findSubsequences(str);
        System.out.println("All Subsequences = " + result);
    }

}
