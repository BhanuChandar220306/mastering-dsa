import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // Map to store (remainder -> earliest_index_where_it_occurred)
        Map<Integer, Integer> map = new HashMap<>();
        
        // Base case: A remainder of 0 conceptually occurs at index -1
        // This handles cases where a good subarray starts right from index 0
        map.put(0, -1);
        
        int runningSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            
            // Calculate remainder safely
            int remainder = runningSum % k;
            
            // If the remainder has been seen before
            if (map.containsKey(remainder)) {
                // Check if the subarray length is at least 2
                if (i - map.get(remainder) >= 2) {
                    return true;
                }
            } else {
                // Only track the earliest occurrence of the remainder
                map.put(remainder, i);
            }
        }
        
        return false;
    }
}