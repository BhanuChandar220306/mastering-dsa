class Solution {
    public int subarraySum(int[] nums, int k) {
       Map<Integer,Integer> hmap=new HashMap<Integer,Integer>();
       int count=0;
       int sum=0;
       hmap.put(0,1);
       for(int i=0;i<nums.length;i++)
       {
        sum+=nums[i];
        int dif=sum-k;
        if(hmap.containsKey(dif))
        {
            count+=hmap.get(dif);
        }
        hmap.put(sum,hmap.getOrDefault(sum,0)+1);
       }
       return count;
    }
}