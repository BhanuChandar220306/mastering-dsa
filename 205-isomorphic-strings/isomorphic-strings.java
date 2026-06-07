class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        // Arrays to store the last seen index + 1 of each character
        int[] mapS = new int[256];
        int[] mapT = new int[256];

        for (int i = 0; i < s.length(); i++) {
            // If the previous positions don't match, they aren't isomorphic
            if (mapS[s.charAt(i)] != mapT[t.charAt(i)]) {
                return false;
            }
            
            // Record the current position (i + 1 to avoid default 0 conflicts)
            mapS[s.charAt(i)] = i + 1;
            mapT[t.charAt(i)] = i + 1;
        }

        return true;
    }
}