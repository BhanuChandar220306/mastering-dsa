class Solution {
    public String minWindow(String s, String t) {
        int minlen=Integer.MAX_VALUE;
        int sindex=-1;
        int[] hash=new int[256];
        for(char c:t.toCharArray())
        {
            hash[c]++;
        }
        int count=0;
        int l=0,r=0;
        while(r<s.length())
        {
            if(hash[s.charAt(r)]>0){
                count++;
            }
            hash[s.charAt(r)]--;

            while(count==t.length())
            {
                if(r-l+1<minlen)
                {
                    minlen=r-l+1;
                    sindex=l;
                }
                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)]>0)
                {
                    count--;
                }
                l++;
            }
            r++;
        }
        return (sindex==-1)?"":s.substring(sindex,sindex+minlen);
    }
}