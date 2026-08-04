import java.util.*;

class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        int max = nums[0];
        int min = nums[0];
        Set<Integer> set = new HashSet<>();

       
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            set.add(num);
        }

        List<Integer> ret = new ArrayList<>();

        
        for (int i = min; i <= max; i++) {
            if (!set.contains(i)) {
                ret.add(i);
            }
        }

        return ret;
    }
}