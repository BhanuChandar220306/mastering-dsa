import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        
        
        if (sLen < pLen) {
            return result;
        }
        
        int[] pCounts = new int[26];
        int[] sCounts = new int[26];
        
        
        for (int i = 0; i < pLen; i++) {
            pCounts[p.charAt(i) - 'a']++;
            sCounts[s.charAt(i) - 'a']++;
        }
        
       
        if (matches(pCounts, sCounts)) {
            result.add(0);
        }
        
        
        for (int i = pLen; i < sLen; i++) {
           
            sCounts[s.charAt(i) - 'a']++;
            

            sCounts[s.charAt(i - pLen) - 'a']--;
            

            if (matches(pCounts, sCounts)) {
                result.add(i - pLen + 1);
            }
        }
        
        return result;
    }
    

    private boolean matches(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}