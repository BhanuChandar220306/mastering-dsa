import java.util.Arrays;

class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long low = 1;
        long high = Long.MAX_VALUE;
        
        // Find the minimum time taken by any single bus to optimize our upper bound
        int minTime = Integer.MAX_VALUE;
        for (int t : time) {
            minTime = Math.min(minTime, t);
        }
        
        // Upper bound: fastest bus completing all totalTrips
        high = (long) minTime * totalTrips;
        
        long ans = high;
        
        while (low <= high) {
            long mid = low + (high - low) / 2;
            
            if (canComplete(time, mid, totalTrips)) {
                ans = mid;       // 'mid' is a feasible answer, save it
                high = mid - 1;  // Try to find a smaller minimal time
            } else {
                low = mid + 1;   // 'mid' is not enough time, search for larger values
            }
        }
        
        return ans;
    }
    
    // Helper function to calculate total trips completed by all buses in given 'givenTime'
    private boolean canComplete(int[] time, long givenTime, int totalTrips) {
        long actualTrips = 0;
        for (int t : time) {
            actualTrips += givenTime / t;
            // Early exit condition if actualTrips overflows or easily satisfies the goal
            if (actualTrips >= totalTrips) {
                return true;
            }
        }
        return actualTrips >= totalTrips;
    }
}