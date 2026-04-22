class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Set<Integer> visited = new HashSet<>();

        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            if (visited.contains(i)) continue;
            visited.add(i);

            Map<Character, Integer> anagramMap = new HashMap<>();
            for (char c : strs[i].toCharArray()) {
                if (anagramMap.get(c) == null) {
                    anagramMap.put(c, 1);
                } else {
                    anagramMap.put(c, anagramMap.get(c) + 1);
                }
            }

            // add this word into a new list
            List<String> anagramGroup = new ArrayList<>();
            anagramGroup.add(strs[i]);

            for (int j = i + 1; j < strs.length; j++) {
                Map<Character, Integer> mapCopy = new HashMap<>(anagramMap);
                if (visited.contains(j)) continue;

                for (char c : strs[j].toCharArray()) {
                    if (mapCopy.get(c) == null || mapCopy.get(c) == 0) {
                        break; // not an anagram
                    }

                    mapCopy.put(c, mapCopy.get(c) - 1);
                }

                if (!mapCopy.values().stream().anyMatch(n -> n != 0)) {
                    anagramGroup.add(strs[j]);
                    visited.add(j);
                }
                    
            }

            result.add(anagramGroup);
        }

        return result;
    }
}
