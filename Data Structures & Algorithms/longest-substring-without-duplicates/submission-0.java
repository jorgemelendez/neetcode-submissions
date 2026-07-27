class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] charArray = s.toCharArray();
        int lft = 0, rgt = 0;

        int max = 0;
        Set<Character> set = new HashSet<>();
        while (rgt < s.size()) {
            if (!set.contains(charArray[rgt])) {
                set.add(charArray[rgt]);
                rgt++;

                max = Math.max(max, set.size());
            } else {
                // need to start shrinking window until can add again
                set.remove(charArray[lft]);
                lft++;
            }
        }   

        return max;
    }
}
