class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer,Integer> hmap=new HashMap<>();
        hmap.put(0,1);
        int count=0;
        int sum=0;
        for(int num:nums)
        {
            sum+=(num%2==0)?0:1;
            if(hmap.containsKey(sum-k))
            {
                count+=hmap.get(sum-k);
            }
            hmap.put(sum,hmap.getOrDefault(sum,0)+1);
        }
        return count;
    }
}