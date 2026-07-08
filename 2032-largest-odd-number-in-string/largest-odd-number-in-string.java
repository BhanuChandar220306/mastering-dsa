class Solution {
    public String largestOddNumber(String num) {
        // Scan from right to left
        for (int i = num.length() - 1; i >= 0; i--) {
            // Check if the character at index i is an odd number
            // (char - '0' converts the character to its actual integer value)
            if ((num.charAt(i) - '0') % 2 != 0) {
                // If found, the largest odd number is from index 0 to i
                return num.substring(0, i + 1);
            }
        }
        
        // If no odd digit is found, return an empty string
        return "";
    }
}