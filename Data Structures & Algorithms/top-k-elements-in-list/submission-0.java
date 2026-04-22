class Solution {
    public int[] topKFrequent(int[] nums, int k) {


        Map<Integer, Integer> ocurrences = new HashMap<>();
        for (int num : nums) {
            ocurrences.put(num, ocurrences.computeIfAbsent(num, q -> 0) + 1);
        }

        List<Integer>[] results = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : ocurrences.entrySet()) {
            List<Integer> bucket = results[entry.getValue()];
            if (bucket == null) {
                List<Integer> newBucket =  new ArrayList<>();
                newBucket.add(entry.getKey());
                results[entry.getValue()] = newBucket;
            } else {
                bucket.add(entry.getKey());
            }
        }

        int[] uniqueResults = new int[k];
        int index = 0;
        for (int i = results.length - 1; i > 0 && index < k; i--) {
            if (results[i] != null) {
                for (Integer val : results[i]) {
                    uniqueResults[index] = val;
                    index++;
                 }
            }
            
        }

        return uniqueResults;
    }
}
