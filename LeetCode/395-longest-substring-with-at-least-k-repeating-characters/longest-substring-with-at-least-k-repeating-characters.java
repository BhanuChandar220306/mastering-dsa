public class Solution {
    public int longestSubstring(String s, int k) {
        int maxLen = 0;
        int n = s.length();
        
       
        for (int currUniqueTarget = 1; currUniqueTarget <= 26; currUniqueTarget++) {
            int[] counts = new int[26];
            int left = 0, right = 0;
            int uniqueInWindow = 0;
            int countAtLeastK = 0;
            
            while (right < n) {

                if (uniqueInWindow <= currUniqueTarget) {
                    int idx = s.charAt(right) - 'a';
                    if (counts[idx] == 0) {
                        uniqueInWindow++;
                    }
                    counts[idx]++;
                    if (counts[idx] == k) {
                        countAtLeastK++;
                    }
                    right++;
                }
                

                while (uniqueInWindow > currUniqueTarget) {
                    int idx = s.charAt(left) - 'a';
                    if (counts[idx] == k) {
                        countAtLeastK--;
                    }
                    counts[idx]--;
                    if (counts[idx] == 0) {
                        uniqueInWindow--;
                    }
                    left++;
                }
                

                if (uniqueInWindow == currUniqueTarget && uniqueInWindow == countAtLeastK) {
                    maxLen = Math.max(maxLen, right - left);
                }
            }
        }
        
        return maxLen;
    }
}