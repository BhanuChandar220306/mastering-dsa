import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> seen = new HashSet<>();
        HashSet<String> duplicates = new HashSet<>();
        
       
        for (int i = 0; i <= s.length() - 10; i++) {
            
            String currentWindow = s.substring(i, i + 10);
            
            
            if (seen.contains(currentWindow)) {
                duplicates.add(currentWindow);
            } else {
                
                seen.add(currentWindow);
            }
        }
        
        
        return new ArrayList<>(duplicates);
    }
}