// http://leetcode.com/2011/05/longest-substring-without-repeating-characters.html

package marouenj.dsa.leetcode;

public class LongestSubstringWithoutRepeatingCharacters {

    public static Integer length(String str) {
        if (str == null)
            return null;

        int maxlen = 0;
        int i = 0;
        int j = 0;

        Boolean[] exists = new Boolean[26];
        for (int idx = 0; idx < exists.length; idx++)
            exists[idx] = false;

        while (j < str.length()) {
            int curr = str.charAt(j) - 'a';
            if (exists[curr]) {
                maxlen = Math.max(maxlen, j - i);
                while (str.charAt(i) != str.charAt(j)) {
                    exists[str.charAt(i) - 'a'] = false;
                    i++;
                }
                i++;
            } else {
                exists[curr] = true;
            }
            j++;
        }
        maxlen = Math.max(maxlen, str.length() - i);
        return maxlen;
    }

    public static void main(String[] args) {
        String str = "abcdefabcdefg";
        System.out.println(length(str));
    }

}
