class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        int i = 0;
        List<String> decodedStr = new ArrayList<>();

        while (i < str.length()) {
            int j = i;
            while(str.charAt(j) != '#') {
                j++;
            }

            int wordLength = Integer.parseInt(str.substring(i, j));
            decodedStr.add(str.substring(j + 1, j + 1 + wordLength));
            i = j + 1 + wordLength;
        }

        return decodedStr;
    }
}
