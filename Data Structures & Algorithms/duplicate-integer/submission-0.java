class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> processed = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!processed.add(nums[i])) {
                return true;
            }
        }

        return false;
    }
}