class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        int leftSum = 0;
        
        // Step 1: Calculate the total sum of the array
        for (int num : nums) {
            totalSum += num;
        }
        
        // Step 2: Iterate and check if left sum equals right sum
        for (int i = 0; i < nums.length; i++) {
            // Right sum is total sum minus left sum minus the current element
            int rightSum = totalSum - leftSum - nums[i];
            
            if (leftSum == rightSum) {
                return i;
            }
            
            // Update left sum for the next iteration
            leftSum += nums[i];
        }
        
        return -1;
    }
}