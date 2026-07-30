class Solution {
    public boolean isPalindrome(String s) {
        char[] sTrim = s.trim().replaceAll("[^A-Za-z0-9]", "").toLowerCase().toCharArray();
        int lft = 0, rgt = sTrim.length - 1;

        while (lft < rgt) {
            if (sTrim[lft] != sTrim[rgt]) {
                return false;
            }

            lft++;
            rgt--;
        }

        return true;
    }
}
