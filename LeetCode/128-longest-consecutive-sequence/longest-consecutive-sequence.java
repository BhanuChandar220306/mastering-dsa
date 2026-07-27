import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Step 1: Insert all numbers into a HashSet (de-duplicates the input)
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        // FIX: Iterate over the SET, not the 'nums' array
        for (int num : set) { 
            // Check if 'num' is the START of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentCount = 1;

                // Count how long this sequence goes
                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentCount += 1;
                }

                longest = Math.max(longest, currentCount);
            }
        }

        return longest;
    }
}