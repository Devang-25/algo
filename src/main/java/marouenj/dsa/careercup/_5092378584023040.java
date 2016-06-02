package marouenj.dsa.careercup;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// https://www.careercup.com/question?id=5092378584023040
// Group anagrams together
// Example: star, dog, car, rats, arc -> {(star, rats), (arc, car), dog)
public class _5092378584023040 {

    public HashMap<String, Set<String>> solution(String[] words) {
        HashMap<String, Set<String>> anagrams = new HashMap<>();

        for (String word : words) {
            // calculate occurrences of each letter
            int[] occurrences = new int[26];
            for (char c : word.toCharArray()) {
                occurrences[(int) c - (int) 'a']++;
            }

            // create fingerprint
            String fingerprint = "";
            for (int occurrence : occurrences) {
                fingerprint += String.valueOf(occurrence) + "_";
            }

            // look up fingerprint
            if (!anagrams.containsKey(fingerprint)) {
                anagrams.put(fingerprint, new HashSet<>());
            }

            // add word
            Set<String> set = anagrams.get(fingerprint);
            set.add(word);
            anagrams.put(fingerprint, set);
        }

        return anagrams;
    }
}
