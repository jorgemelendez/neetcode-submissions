class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        List<Integer> subset = new ArrayList<>();
        dfs(0, nums, subset, list);

        return list;
    }


    public void dfs(
        int pos, 
        int[] nums, 
        List<Integer> subset, 
        List<List<Integer>> list
        ) {

        if (pos >= nums.length) {
            list.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[pos]);
        dfs(pos + 1, nums, subset, list);

        subset.remove(subset.size() - 1);
        dfs(pos + 1, nums, subset, list);
    }

    public List<Integer> convertToList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        return list;
    }
}
