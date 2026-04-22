class Solution {
    public boolean isValidSudoku(char[][] board) {
        // horizontal
        for (int i = 0; i < board.length; i++) {
            int[] set = new int[10];
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int pos = Character.getNumericValue(board[i][j]);
                    if (set[pos] == 1) {
                        return false;
                    }

                    set[pos] = 1;
                }
            }
        }


        // verify horizontals
        for (int i = 0; i < board.length; i++) {
            int[] set = new int[10];
            for (int j = 0; j < board[0].length; j++) {
                if (board[j][i] != '.') {
                    int pos = Character.getNumericValue(board[j][i]);
                    if (set[pos] == 1) {
                        return false;
                    }

                    set[pos] = 1;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            int[] set1 = new int[10];
            int[] set2 = new int[10];
            int[] set3 = new int[10];


            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (board[i * 3 + j][k] != '.') {
                        int pos = Character.getNumericValue(board[i * 3 + j][k]);
                        if (set1[pos] == 1) {
                            return false;
                        }

                        set1[pos] = 1;
                    }

                    if (board[i * 3 + j][k + 3] != '.') {
                        int pos = Character.getNumericValue(board[i * 3 + j][k + 3]);
                        if (set2[pos] == 1) {
                            return false;
                        }

                        set2[pos] = 1;
                    }

                    if (board[i * 3 + j][k + 6] != '.') {
                        int pos = Character.getNumericValue(board[i * 3 + j][k + 6]);
                        if (set3[pos] == 1) {
                            return false;
                        }

                        set3[pos] = 1;
                    }
                }
            }


        }

        return true;
    }
}
