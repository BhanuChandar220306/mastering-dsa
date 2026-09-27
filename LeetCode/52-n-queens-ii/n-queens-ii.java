class Solution {
    public int totalNQueens(int n) {
        int[] leftrow = new int[n];
        int[] upperdiagonal = new int[2 * n - 1];
        int[] lowerdiagonal = new int[2 * n - 1];
        return solve(0, leftrow, upperdiagonal, lowerdiagonal, n);
    }

    private int solve(int col, int[] leftrow, int[] upperdiagonal, int[] lowerdiagonal, int n) {
        if (col == n) {
            return 1; 
        }
        int count = 0;
        for (int row = 0; row < n; row++) {
            if (leftrow[row] == 0 && lowerdiagonal[row + col] == 0 && upperdiagonal[n - 1 + col - row] == 0) {
                leftrow[row] = 1;
                lowerdiagonal[row + col] = 1;
                upperdiagonal[n - 1 + col - row] = 1;
                count += solve(col + 1, leftrow, upperdiagonal, lowerdiagonal, n);
                leftrow[row] = 0;
                lowerdiagonal[row + col] = 0;
                upperdiagonal[n - 1 + col - row] = 0;
            }
        }

        return count;
    }
}