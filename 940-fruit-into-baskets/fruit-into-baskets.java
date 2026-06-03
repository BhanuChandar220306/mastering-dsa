class Solution {
    public int totalFruit(int[] fruits) {
        int maxlen=0;
        int right=0;
        int left=0;
        Map<Integer,Integer> a=new HashMap<>();
        int n=fruits.length;
        while(right<n)
        {
            a.put(fruits[right],a.getOrDefault(fruits[right],0)+1);
            if(a.size()>2)
            {
                a.put(fruits[left],a.get(fruits[left])-1);
                if(a.get(fruits[left])==0)
                    a.remove(fruits[left]);
                left++;
            }
            if(a.size()<=2)
                maxlen=Math.max(maxlen,right-left+1);
            right++;
        }
        return maxlen;
    }
}