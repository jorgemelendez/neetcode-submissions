class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>(Arrays.stream(nums)
        .boxed()
        .collect(Collectors.toSet()));

        int largestSeq = 0;

        for (int i = 0; i < nums.length; i++) {
            int currentSeq = 0;
            if (!set.contains(nums[i] - 1)) {
                currentSeq++;

                boolean hasNextNum = true;
                int offset = 1;
                while (hasNextNum) {
                    if (set.contains(nums[i] + offset)) {
                        currentSeq++;
                        offset++;
                    } else {
                        hasNextNum = false;
                    }
                }
            }
            largestSeq = Math.max(largestSeq, currentSeq);
        }

        return largestSeq;
    }
}
