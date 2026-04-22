class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            counter.put(nums[i], counter.computeIfAbsent(nums[i], c -> 0) + 1);
        }    

        List<Integer>[] bucket = new List[nums.length + 1];
        for(Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            Integer count = entry.getValue();
            Integer val = entry.getKey();
            if (bucket[count] == null) {
                List<Integer> valueList = new ArrayList<>();
                valueList.add(val);
                bucket[count] = valueList;
            } else {
                List<Integer> valueList = bucket[count];
                valueList.add(val);
                bucket[count] = valueList;
            }
        };

        int[] results = new int[k];
        int resultPtr = 0;
        for(int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] == null) {
                continue;
            }

            for (Integer x : bucket[i]) {
                results[resultPtr] = x;
                resultPtr++;

                if (resultPtr >= k) {
                    return results;
                }
            }
        }

        return results;
    }
}
