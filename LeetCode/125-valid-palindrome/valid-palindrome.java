class Solution {
    public boolean isPalindrome(String s) {
        String srep = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        char[] chars=srep.toCharArray();
        int i=0;
        int j=chars.length-1;
        while(i<j)
        {
            if(chars[i]==chars[j])
            {
                i++;
                j--;
            }
            else if(chars[i]!=chars[j])
            {
                return false;
            }
        }
        return true;
    }
}