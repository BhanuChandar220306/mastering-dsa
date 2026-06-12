class Solution {
    public int subarraySum(int[] nums, int k) {
       Map<Integer,Integer> hmap=new HashMap<Integer,Integer>();
       int count=0;
       int sum=0;
       hmap.put(0,1);
       for(int x:nums)
       {
        sum+=x;
        if(hmap.containsKey(sum-k))
        {
            count+=hmap.get(sum-k);
        }
        hmap.put(sum,hmap.getOrDefault(sum,0)+1);
       }
       return count;
    }
}