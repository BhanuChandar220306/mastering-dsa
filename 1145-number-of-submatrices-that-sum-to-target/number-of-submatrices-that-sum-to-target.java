import java.util.*;

class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int ans = 0;

        for (int top = 0; top < rows; top++) {

            int[] colSum = new int[cols];

            for (int bottom = top; bottom < rows; bottom++) {

                for (int c = 0; c < cols; c++) {
                    colSum[c] += matrix[bottom][c];
                }

                ans += countSubarrays(colSum, target);
            }
        }

        return ans;
    }

    private int countSubarrays(int[] arr, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int prefix = 0;
        int count = 0;

        for (int num : arr) {

            prefix += num;

            count += map.getOrDefault(prefix - target, 0);

            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }

        return count;
    }
}