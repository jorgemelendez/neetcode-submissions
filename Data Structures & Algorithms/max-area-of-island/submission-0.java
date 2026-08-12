class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int area = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                area = Math.max(area, dfs(grid, row, col));
            }
        }

        return area;
    }

    public int dfs(int[][] grid, int row, int col) {
        if (row >= grid.length || col >= grid[0].length ||
            row < 0 || col < 0 || grid[row][col] == 0) {
            return 0;
        }

        grid[row][col] = 0; //not use set

        return 1 + dfs(grid, row + 1, col) + dfs(grid, row - 1, col) 
            + dfs(grid, row, col + 1) + dfs(grid, row, col - 1);
    }
}
