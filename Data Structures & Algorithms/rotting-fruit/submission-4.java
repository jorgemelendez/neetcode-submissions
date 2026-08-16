class Solution {
    public int orangesRotting(int[][] grid) {
        // guards
        if (grid == null || grid.length == 0) return 0;

        Queue<Integer> queue = new LinkedList<>();
        int freshCount = 0;

        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(i * cols + j);
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        int minutes = 0;
        while (!queue.isEmpty() && freshCount > 0) {
            int size = queue.size();
            int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for (int i = 0; i < size; i++) {

                int curr = queue.poll();
                int row = curr / cols;
                int col = curr % cols;

                for (int[] dir : directions) {
                    int nr = row + dir[0];
                    int nc = col + dir[1];

                    if (nr >= 0 && nc >= 0 && nr < rows && nc < cols && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        freshCount--;
                        queue.add(nr * cols + nc);
                    }
                }
            }
            minutes++;
        }

        return freshCount == 0 ? minutes : -1;
    }


}
