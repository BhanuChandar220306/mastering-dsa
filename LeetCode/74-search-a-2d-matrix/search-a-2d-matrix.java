class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Edge case check
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int m = matrix.length;    // Number of rows
        int n = matrix[0].length; // Number of columns
        
        // Define binary search boundaries as if it were a 1D array
        int low = 0;
        int high = (m * n) - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // Map the 1D 'mid' index back to 2D coordinates
            int row = mid / n;
            int col = mid % n;
            
            int element = matrix[row][col];
            
            if (element == target) {
                return true; // Target found!
            } else if (element < target) {
                low = mid + 1; // Target is larger, discard the left half
            } else {
                high = mid - 1; // Target is smaller, discard the right half
            }
        }
        
        // Target was not found anywhere in the matrix
        return false;
    }
}