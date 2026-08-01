class Solution {
    public String mergeAlternately(String word1, String word2) {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();

        int smallest = Math.min(w1.length, w2.length);
        int iters = smallest * 2;

        char[] merge = new char[w1.length + w2.length];

        for (int i = 0; i < iters; i++) {
            int pos = i / 2;

            merge[i] = i % 2 == 0 ? w1[pos] : w2[pos];
        }

        char[] largest = w1.length > w2.length ? w1 : w2;
        int offset = 0;
        for (int i = iters; i < merge.length; i++) {
            merge[i] = largest[offset + smallest];
            offset++;
        }

        return new String(merge);
    }
}