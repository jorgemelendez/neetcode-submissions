class Solution {
    public void reverseString(char[] s) {
        int lft = 0, rgt = s.length - 1;
        while (lft < rgt) {
            char tmp = s[rgt];
            s[rgt] = s[lft];
            s[lft] = tmp;
            lft ++;
            rgt --;
        }
    }
}