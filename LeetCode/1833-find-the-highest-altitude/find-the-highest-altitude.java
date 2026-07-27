class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;     // Biker starts at altitude 0, so max is at least 0
        int current = 0; // Tracks the running altitude
        
        for (int i = 0; i < gain.length; i++) {
            current += gain[i];           // Update current altitude with the next gain
            max = Math.max(max, current); // Check if this is the highest peak so far
        }
        
        return max;
    }
}