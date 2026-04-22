class Solution {
    public int removeElement(int[] nums, int val) {
        int lft = 0, rgt = 0;

        while (rgt < nums.length) {
            if (nums[rgt] != val) {
                nums[lft] = nums[rgt];
                lft++;
            }

            rgt++;
        }

        return lft;
    }
}