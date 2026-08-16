class Solution {
    int[][] positions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        if (word.length() == 0 || board == null) return false;

        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (foundLetter(board, i, j, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean foundLetter(char[][] board, int row, int col, String word, int wordPos) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length 
            || wordPos >= word.length() || word.charAt(wordPos) == '%') {
            return false;
        }
        
        if (board[row][col] == word.charAt(wordPos)) {
            if(wordPos == word.length() - 1) {
                return true;
            }
            
            char tmp = board[row][col];
            board[row][col] = '%';
            for (int[] pos : positions) {
                int nr = row + pos[0];
                int nc = col + pos[1];
                if (foundLetter(board, nr, nc, word, wordPos + 1)) {
                    return true;
                }
            }

            board[row][col] = tmp;
        } 

        return false;
    }
}
