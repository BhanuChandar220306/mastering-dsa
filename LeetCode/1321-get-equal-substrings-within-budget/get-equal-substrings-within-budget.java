class Solution {
    public int equalSubstring(String s, String t, int maxcost) {
        int left=0;
        int right=0;
        int maxlen=0;
        int currcost=0;
        while(right<s.length())
        {
            currcost+=Math.abs(s.charAt(right)-t.charAt(right));
            if(currcost>maxcost)
            {
                currcost-=Math.abs(s.charAt(left)-t.charAt(left));
                left++;
            }
            if(currcost<=maxcost)
                maxlen=Math.max(maxlen,right-left+1);
            right++;
        }
        return maxlen;
    }
}