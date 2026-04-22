class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Map<Integer, Integer> first int is the num and second is the index.

        Map<Integer, Integer> results = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (results.containsKey(diff)) {
                return new int[] {results.get(diff), i};
            }

            results.put(nums[i], i);
        }

        return new int[0];
    }
}
