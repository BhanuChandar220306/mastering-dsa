import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findMaxLength(int[] nums) {
        // Map to store (prefix_sum -> earliest_index_where_it_occurred)
        Map<Integer, Integer> map = new HashMap<>();
        
        // Base case: A sum of 0 happens dummy-wise "before" index 0 (at index -1)
        map.put(0, -1);
        
        int maxLen = 0;
        int currentSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // Treat 0 as -1, and 1 as +1
            currentSum += (nums[i] == 0) ? -1 : 1;
            
            // If this sum has been seen before, we found a balanced subarray
            if (map.containsKey(currentSum)) {
                int previousIndex = map.get(currentSum);
                int currentLen = i - previousIndex;
                maxLen = Math.max(maxLen, currentLen);
            } else {
                // Only store the first occurrence to maximize the subarray length later
                map.put(currentSum, i);
            }
        }
        
        return maxLen;
    }
}