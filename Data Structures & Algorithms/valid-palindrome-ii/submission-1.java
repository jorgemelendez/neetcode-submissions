class Solution {
    public boolean validPalindrome(String s) {
                char[] sTrim = s.trim().replaceAll("[^A-Za-z0-9]", "").toLowerCase().toCharArray();
        int lft = 0, rgt = sTrim.length - 1;

        int retries = 1;
        while (lft < rgt) {
            if (sTrim[lft] != sTrim[rgt]) {
                if (retries > 0) retries--;
                else return false;
            }

            lft++;
            rgt--;
        }

        return true;
    }
}