class Solution {
    public int majorityElement(int[] nums) {
        int element = nums[0];
        int num = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == element) {
                num++;
            } else {
                num--;
                if (num == 0) {
                    element = nums[i];
                    num = 1;
                }
            }
        }

        return element;
    }
}