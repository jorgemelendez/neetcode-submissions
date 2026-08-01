class Solution {
    public boolean validPalindrome(String s) {
        char[] sChar = s.toCharArray();

        int left = 0, right = sChar.length - 1;
        while(left <= right) {
            if (sChar[left] != sChar[right]) {
                return isValidPalindrome(sChar, left + 1, right) || isValidPalindrome(sChar, left, right - 1);
            }

            left++;
            right--;
        }

        return true;
    }

    boolean isValidPalindrome(char[] s, int left, int right) {
        while(left < right) {
            if (s[left] != s[right]) return false;
            left++;
            right--;
        }

        return true;
    }
}