class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;

        // Have an array where the position of the character is where we keep the tally
        int[] characterCount = new int[26];
        
        for(char c : s.toLowerCase().toCharArray()) {
            characterCount[c - 'a'] += 1;
        }
        
        for (char c : t.toLowerCase().toCharArray()) {
            if (characterCount[c - 'a'] > 0) {
                characterCount[c - 'a'] -= 1;
            } else {
                return false;
            }
        }

        for (int i = 0; i < characterCount.length; i++) {
            if (characterCount[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
