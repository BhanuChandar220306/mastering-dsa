import java.util.HashSet;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        HashSet<Integer> set = new HashSet<>();

        long sum = 0;
        long maxSum = 0;

        int i = 0;

        for (int j = 0; j < nums.length; j++) {

            
            while (set.contains(nums[j])) {
                set.remove(nums[i]);
                sum -= nums[i];
                i++;
            }

          
            set.add(nums[j]);
            sum += nums[j];

            
            if (j - i + 1 > k) {
                set.remove(nums[i]);
                sum -= nums[i];
                i++;
            }

            
            if (j - i + 1 == k) {
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
}