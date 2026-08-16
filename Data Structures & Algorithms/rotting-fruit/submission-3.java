class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair> rotten = findRottenFruits(grid);

        int minutes = 0;
        while(!rotten.isEmpty()) {
            minutes++;
            int queueSize = rotten.size();
            for (int i = 0; i < queueSize; i++) {
                Pair coords = rotten.poll();
                int x = coords.x;
                int y = coords.y;

                // adding future rotten fruits
                if (x + 1 < grid.length && grid[x + 1][y] == 1) {
                    grid[x+1][y] = 2;
                    rotten.add(new Pair(x+1, y));
                }
                if (x - 1 >= 0 && grid[x-1][y] == 1) {
                    grid[x-1][y] = 2;
                    rotten.add(new Pair(x-1, y));
                }
                if (y + 1 < grid[0].length && grid[x][y + 1] == 1) {
                    grid[x][y+1] = 2;
                    rotten.add(new Pair(x, y + 1));
                } 
                if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                    grid[x][y-1] = 2;
                    rotten.add(new Pair(x, y - 1));
                }
            }
        }


        return findRemainingFruit(grid).isEmpty() ? minutes - 1 : -1;
    }

    public Queue<Pair> findRottenFruits(int[][] grid) {
        Queue<Pair> rotten = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    rotten.add(new Pair(i, j));
                }
            }
        }

        return rotten;
    }

    public Queue<Pair> findRemainingFruit(int[][] grid) {
        Queue<Pair> rotten = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 || grid[i][j] == 1) {
                    rotten.add(new Pair(i, j));
                }
            }
        }

        return rotten;
    }


    class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
