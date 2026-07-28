import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        // Split the string s into individual words
        String[] words = s.split(" ");
        
        // If lengths don't match, the pattern cannot match
        if (pattern.length() != words.length) {
            return false;
        }
        
        // Map to track pattern character -> word
        Map<Character, String> charToWord = new HashMap<>();
        // Set to track words that have already been assigned to a character
        Set<String> usedWords = new HashSet<>();
        
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = words[i];
            
            // Check if this character already has a mapping
            if (charToWord.containsKey(ch)) {
                // If the existing mapping doesn't match the current word, break rule
                if (!charToWord.get(ch).equals(word)) {
                    return false;
                }
            } else {
                // If the character is new, ensure the word hasn't been claimed by someone else
                if (usedWords.contains(word)) {
                    return false; // Word is already bound to a different character
                }
                
                // Establish the new bidirectional bond
                charToWord.put(ch, word);
                usedWords.add(word);
            }
        }
        
        return true;
    }
}