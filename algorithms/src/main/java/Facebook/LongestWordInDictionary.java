package Facebook;

import java.util.*;

/**
 * Created by archithrapaka on 5/1/17.
 */
public class LongestWordInDictionary {

    public static String findLongestWord(String s, List<String> d) {
        if (null == d || d.size() == 0 || null == s || s.length() == 0) {
            return "";
        }

        int max = -1;
        Collections.sort(d);
        boolean exist = false;
        for (int i = 0; i < d.size(); i++) {
            String word = d.get(i);
            if (charMatch(s, word)) {
                if (max == -1) {
                    max = i;
                    exist = true;
                }
                if (word.length() > d.get(max).length()) {
                    max = i;
                }
            }
        }
        if (!exist) {
            return "";
        }
        return d.get(max);
    }

    // if the substring is of same length , then lexicographical substring comes first
    public static String findLongestWord2(String s, List<String> d) {
        if (null == d || d.size() == 0 || null == s || s.length() == 0) {
            return "";
        }
        String longest = "";

        for (int i = 0; i < d.size(); i++) {
            String word = d.get(i);
            if (charMatch(s, word)) {

                if (word.length() > longest.length()) {
                    longest = word;
                } else if (word.length() == longest.length()) {
                    if (word.compareTo(longest) < 0) {
                        longest = word;
                    }
                }
            }
        }
        return longest;
    }

    public static boolean charMatch(String s, String b) {
        int i = 0;
        int j = 0;

        while (i < s.length() && j < b.length()) {
            if (s.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == b.length() ? true : false;
    }

    static class Word {
        String word;
        int index;

        public Word(String word, int index) {
            this.word = word;
            this.index = index;
        }
    }

    public static String findLongestWord3(String s, List<String> d) {
        if (null == d || d.size() == 0 || null == s || s.length() == 0) {
            return "";
        }
        String longest = "";
        Word longestWord = new Word(longest, -1);
        for (int i = 0; i < d.size(); i++) {
            String word = d.get(i);

            if (charMatch2(s, word) >= 0) {
                int index = charMatch2(s, word);
                Word current = new Word(word, index);
                if (current.word.length() > longestWord.word.length()) {
                    longestWord = current;
                } else if (word.length() == longestWord.word.length()) {
                    if (current.index < longestWord.index) {
                        longestWord = current;
                    }
                }
            }
        }
        return longestWord.word;
    }

    public static String findLongestWord4(String s, Map<String, Boolean> parts) {
        if (null == parts || null == s || s.isEmpty()) {
            return "";
        }
        String longest = "";
        Word longestWord = new Word(longest, -1);

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String word = s.substring(i, j + 1);
                if (parts.containsKey(word)) {
                    int index = i;
                    Word current = new Word(word, i);

                    if (current.word.length() > longestWord.word.length()) {
                        longestWord = current;
                    } else if (word.length() == longestWord.word.length()) {
                        if (current.index < longestWord.index) {
                            longestWord = current;
                        }
                    }
                }
            }
        }
        return longestWord.word;
    }


    public static int charMatch2(String s, String sub) {
        return s.indexOf(sub);
    }

    public static String findIndexOfSubstr(String s, String substr) {
        int index = s.indexOf(substr);
        if (index == -1) {
            return "";
        }
        StringBuilder sb = new StringBuilder("");

        sb.append(s.substring(0, index));
        sb.append("[");
        sb.append(s.substring(index, index + substr.length()));
        sb.append("]");
        sb.append(s.substring(index + substr.length()));
        return sb.toString();
    }

    public static void main(String[] args) {
        //String s = "aewfafwafjlwajflwajflwafj";
        //List<String> list = Arrays.asList(new String[]{"apple","ewaf","awefawfwaf","awef","awefe","ewafeffewafewf"});
        //System.out.println(findLongestWord2(s,list));

        String[] parts = new String[]{
                "d",
                "i"};
        String[] words = new String[]{
                "coccidiosis",
                "gules"};
        String[] answers = new String[words.length];
        HashMap<String, Boolean> map = new HashMap<>();

        for (String part : parts) {
            map.put(part, true);
        }

        int i = 0;
        for (String word : words) {
            String longest = findLongestWord4(word, map);
            if (longest.isEmpty()) {
                longest = word;
            } else {
                longest = findIndexOfSubstr(word, longest);
            }

            answers[i] = longest;
            i++;
        }

        for (String answer : answers) {
            System.out.print(answer + " ");
        }
        //int inde = findIndexOfSubstr("Melon","Mel");
        //System.out.print(findIndexOfSubstr("WaterMelon","Mel"));
        //System.out.println(findLongestWord2("establish",Arrays.asList(parts)));
        //System.out.println("coccidiosis".indexOf("i"));
        //System.out.println("coccidiosis".indexOf("d"));
        String a = "50";
        String b = "20";
        //System.out.print(-1.0/0);
        //System.out.print(a & !b);
    }
}
