/**
 * This is a comment!
 *
 * @class: ValidAnagram
 * @description: 242. Valid Anagram
 * @author: Xincheng Huang - xinchenh
 * @create: 02-24-2019 00:11
 **/
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        char[] dictionary = new char[26];
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            dictionary[cs - 'a']++;
            dictionary[ct - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (dictionary[i] != 0)
                return false;
        }
        return true;
    }
}
