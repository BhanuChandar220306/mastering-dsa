class Solution {
    public int characterReplacement(String s, int k) {
        int maxlen=0;
        int maxfreq=0; 
        int n=s.length();
        int hasharray[]=new int[26];
        int l=0;
        int r=0;
        while(r<n)
        {
            hasharray[s.charAt(r)-'A']++;
            maxfreq=Math.max(maxfreq,hasharray[s.charAt(r)-'A']);
            if((r-l+1)-maxfreq>k)
            {
                hasharray[s.charAt(l)-'A']--;
                maxfreq=0;
                for(int i=0;i<26;i++)
                {
                    maxfreq=Math.max(maxfreq,hasharray[i]);
                }
                l++;
            }
            if((r-l+1)-maxfreq<=k)
                maxlen=Math.max(maxlen,r-l+1);
            r++;
        }
        return maxlen;
    }
}