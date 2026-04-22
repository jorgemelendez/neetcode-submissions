class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        String[] sortedStrs = new String[strs.length];
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            sortedStrs[i] = sortedStr;
        }

        Map<String, List<String>> results = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            results.computeIfAbsent(sortedStrs[i], k -> new ArrayList<>()).add(strs[i]);
        }

        return new ArrayList<>(results.values());
    }
}
