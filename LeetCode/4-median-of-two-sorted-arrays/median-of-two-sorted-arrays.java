class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array to optimize binary search to O(log(min(m, n)))
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int m = nums1.length;
        int n = nums2.length;
        int low = 0;
        int high = m;
        
        while (low <= high) {
            // Partition positions
            int partitionX = (low + high) / 2;
            int partitionY = (m + n + 1) / 2 - partitionX;
            
            // L1, R1 representing the boundary elements of nums1
            int L1 = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int R1 = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];
            
            // L2, R2 representing the boundary elements of nums2
            int L2 = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int R2 = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];
            
            // Check if we have found the correct partition
            if (L1 <= R2 && L2 <= R1) {
                // If total elements are odd
                if ((m + n) % 2 == 1) {
                    return Math.max(L1, L2);
                } 
                // If total elements are even
                else {
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2.0;
                }
            } else if (L1 > R2) {
                // Too far right in nums1, move partition left
                high = partitionX - 1;
            } else {
                // Too far left in nums1, move partition right
                low = partitionX + 1;
            }
        }
        
        throw new IllegalArgumentException("Input arrays are not sorted.");
    }
}