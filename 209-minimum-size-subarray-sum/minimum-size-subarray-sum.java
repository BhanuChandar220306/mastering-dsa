class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i,j,sum,minlen;
        i=j=sum=0;
        minlen=Integer.MAX_VALUE;
        while(j<nums.length)
        {
            sum=sum+nums[j];
            while(sum>=target)
            {
                minlen=Math.min(minlen,j-i+1);
                sum-=nums[i];
                i++;
            }
            j++;
        }
        return minlen==Integer.MAX_VALUE?0:minlen;
    }
}