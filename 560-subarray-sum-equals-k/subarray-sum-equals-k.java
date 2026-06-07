import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        // Map to store (prefix_sum, frequency_of_occurrence)
        Map<Integer, Integer> map = new HashMap<>();
        
        // Base case: A prefix sum of 0 has occurred 1 time (before any elements)
        map.put(0, 1);
        
        int currentSum = 0;
        int count = 0;
        
        for (int num : nums) {
            // Update the running prefix sum
            currentSum += num;
            
            // Check if (currentSum - k) exists in our map
            if (map.containsKey(currentSum - k)) {
                count += map.get(currentSum - k);
            }
            
            // Add/Update the current prefix sum in the map
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
    }
}