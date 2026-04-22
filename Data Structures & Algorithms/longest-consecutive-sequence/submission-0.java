class Solution {
    public int longestConsecutive(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        int highestCount = 0;
        
        for (int i = 0; i < nums.length; i++) {
            Integer num = queue.peek();
            if (num == null) {
                queue.add(nums[i]);
                highestCount = Math.max(highestCount, queue.size());
                continue;
            }

            if (num > nums[i]) {
                queue.poll();
            }

            queue.add(nums[i]);
            highestCount = Math.max(highestCount, queue.size());
        }


        return highestCount;
    }
}
