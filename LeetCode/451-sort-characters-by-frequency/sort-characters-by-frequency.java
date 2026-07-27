import java.util.*;

class Solution {
    public String frequencySort(String s) {
        // Step 1: Count frequency of each character
        Map<Character, Integer> hmap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            hmap.put(c, hmap.getOrDefault(c, 0) + 1);
        }
        
        // Step 2: Use a Max-Heap (PriorityQueue) to sort characters by frequency
        // (b, a) -> hmap.get(b) - hmap.get(a) places the highest frequency at the top
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> hmap.get(b) - hmap.get(a));
        maxHeap.addAll(hmap.keySet());
        
        // Step 3: Build the resulting string
        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char c = maxHeap.poll();
            int count = hmap.get(c);
            // Append the character 'count' times
            for (int i = 0; i < count; i++) {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}