class Solution {
    public int romanToInt(String s) {
        int total = 0;
        int length = s.length();
        
        for (int i = 0; i < length; i++) {
            int currentVal = getValue(s.charAt(i));
            
            // Check if there is a next character and if it's larger than the current one
            if (i + 1 < length && currentVal < getValue(s.charAt(i + 1))) {
                // Subtraction case (e.g., IV -> -1 + 5 = 4)
                total -= currentVal;
            } else {
                // Standard addition case
                total += currentVal;
            }
        }
        
        return total;
    }
    
    // Helper method to quickly fetch Roman numeral values
    private int getValue(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}