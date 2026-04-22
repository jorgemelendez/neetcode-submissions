class NumMatrix {
    private int[][] sumMatrix;

    public NumMatrix(int[][] matrix) {
        this.sumMatrix = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                sum += matrix[i][j];
                this.sumMatrix[i+1][j+1] = sum + this.sumMatrix[i][j+1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1 = row1 + 1;
        col1 = col1 + 1;
        row2 = row2 + 1;
        col2 = col2 + 1;

        int area = this.sumMatrix[row2][col2];
        int above = this.sumMatrix[row1 - 1][col2];
        int left = this.sumMatrix[row2][col1 - 1];
        int leftAbove = this.sumMatrix[row1-1][col1-1];

        return area - above - left + leftAbove;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */