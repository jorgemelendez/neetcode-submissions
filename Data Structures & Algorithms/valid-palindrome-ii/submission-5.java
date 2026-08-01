class Solution {
    public boolean validPalindrome(String s) {
        char[] sChar = s.toCharArray();

        int left = 0, right = sChar.length - 1;
        int deletionsLeft = 1;
        while(left <= right) {
            if (sChar[left] != sChar[right]) {
                if (deletionsLeft == 0 ) {
                    return false;
                }

                // check if next left is 
                if (sChar[left + 1] == sChar[right]) {
                    left++;
                    continue;
                } else if (sChar[left] == sChar[right- 1]) {
                    right--;
                    continue;
                } else {
                    return false;
                }
                deletionsLeft--;
            }

            left++;
            right--;
        }

        return true;
    }
}