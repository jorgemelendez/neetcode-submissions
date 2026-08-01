class Solution {
    public String mergeAlternately(String word1, String word2) {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int iters = Math.min(w1.length, w2.length) * 2;
        char[] merge = new char[w1.length + w2.length];

        for (int i = 0; i < iters; i++) {
            int pos = i / 2;

            merge[i] = i % 2 == 0 ? w1[pos] : w2[pos];
        }

        System.out.println(new String(merge));

        for (int i = iters / 2; i < Math.max(w1.length, w2.length); i++) {
            char[] longest = w1.length > w2.length ? w1 : w2;
            merge[i] = longest[i];
        }

        return new String(merge);
    }
}