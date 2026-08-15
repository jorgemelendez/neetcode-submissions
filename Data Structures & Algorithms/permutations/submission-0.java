class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            result.add(new ArrayList<>());
            return result;
        }

        int[] newNums = Arrays.copyOfRange(nums, 1, nums.length);
        List<List<Integer>> perms = permute(newNums);

        for(List<Integer> list : perms) {
            for (int i = 0; i < list.size() + 1; i++) {
                List<Integer> copy = new LinkedList<>(list);
                copy.add(i, nums[0]);
                result.add(copy);
            }
        }

        return result;
    }
}
