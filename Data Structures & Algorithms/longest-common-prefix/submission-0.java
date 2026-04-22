class Solution {
    public String longestCommonPrefix(String[] strs) {
        String commonSubStr = strs[0];

        for (int i = 0; i < strs.length; i++) {
            char[] commonSubStrArr = commonSubStr.toCharArray();
            char[] currSubStrArr = strs[i].toCharArray();

            int minLength = Math.min(commonSubStrArr.length, currSubStrArr.length);
            
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < minLength; j++) {
                if (commonSubStrArr[j] != currSubStrArr[j]) {
                    break;
                }

                sb.append(commonSubStrArr[j]);
            }
            commonSubStr = sb.toString();
        }


        return commonSubStr;
    }
}