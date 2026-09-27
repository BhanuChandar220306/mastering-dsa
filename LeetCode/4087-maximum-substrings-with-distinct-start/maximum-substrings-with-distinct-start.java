class Solution {
    public int maxDistinct(String s) {
        Set<Character> hs=new HashSet<>();
        char[] ch=s.toCharArray();
        for(int i=0;i<s.length();i++)
        {
            hs.add(ch[i]);
        }
        return hs.size();
    }
}