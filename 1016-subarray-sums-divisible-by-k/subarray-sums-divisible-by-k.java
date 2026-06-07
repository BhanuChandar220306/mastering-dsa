class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        // Since remainders can only be from 0 to k-1, an array acts as a perfect, ultra-fast map
        int[] remainderCounts = new int[k];
        
        // Base case: remainder 0 has appeared 1 time initially
        remainderCounts[0] = 1;
        
        int runningSum = 0;
        int totalSubarrays = 0;
        
        for (int num : nums) {
            runningSum += num;
            
            // Normalize remainder to be positive
            int remainder = (runningSum % k + k) % k;
            
            // Add the number of times this remainder has been seen before
            totalSubarrays += remainderCounts[remainder];
            
            // Increment the count for the current remainder
            remainderCounts[remainder]++;
        }
        
        return totalSubarrays;
    }
}