class Solution {
    public void sortColors(int[] nums) {
        int lft = 0, rgt = nums.length - 1;
        int i = 0;

        while (i <= rgt) {
            if (nums[i] == 0) {
                int tmp = nums[lft];
                nums[lft] = nums[i];
                nums[i] = tmp;
                i++;
                lft++;
            } else if (nums[i] == 2) {
                int tmp = nums[rgt];
                nums[rgt] = nums[i];
                nums[i] = tmp;
                rgt--;
            } else {
                i++;
            }
        }
    }
}