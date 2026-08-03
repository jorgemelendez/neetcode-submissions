class Solution {
    public boolean isValid(String s) {
        Deque<Character> q = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++) {
            char bracket = s.charAt(i);

            if (bracket == '{' || bracket == '[' || bracket == '(') {
                q.push(bracket);
                continue;
            }

            char openingBracket = q.pop();
            if (openingBracket == '{' && bracket == '}'
                || openingBracket == '(' && bracket == ')'
                || openingBracket == '[' && bracket == ']') {
                    continue;
                }

            return false;
        }

        return true;
    }
}
