import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        // Base case: if lengths don't match, they can't be isomorphic
        if (s.length() != t.length()) {
            return false;
        }
        
        // Map to track s -> t mappings
        Map<Character, Character> sToT = new HashMap<>();
        // Map to track t -> s mappings (ensures 1-to-1 uniqueness)
        Map<Character, Character> tToS = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            
            // Check if charS already has a mapping
            if (sToT.containsKey(charS)) {
                if (sToT.get(charS) != charT) {
                    return false; // Mismatched mapping found
                }
            } else {
                // If charS is new, make sure charT hasn't been claimed yet
                if (tToS.containsKey(charT)) {
                    return false; // Many-to-one mapping attempt
                }
                
                // Establish the bidirectional mapping
                sToT.put(charS, charT);
                tToS.put(charT, charS);
            }
        }
        
        return true;
    }
}