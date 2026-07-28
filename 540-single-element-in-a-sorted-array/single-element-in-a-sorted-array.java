class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            if (mid % 2 == 0) {
                // Case 1: mid is an EVEN index
                if (nums[mid] == nums[mid + 1]) {
                    // Pair is normal (even -> odd). Single element is to the right.
                    low = mid + 2; 
                } else {
                    // Pair is disrupted. Single element is to the left or IS mid.
                    high = mid;
                }
            } else {
                // Case 2: mid is an ODD index
                if (nums[mid] == nums[mid - 1]) {
                    // Pair is normal (even -> odd). Single element is to the right.
                    low = mid + 1;
                } else {
                    // Pair is disrupted. Single element is to the left or IS mid.
                    high = mid;
                }
            }
        }
        
        // low and high will converge exactly on the single element
        return nums[low];
    }
}