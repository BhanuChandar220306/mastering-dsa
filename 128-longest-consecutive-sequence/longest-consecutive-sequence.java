class Solution {
    public int longestConsecutive(int[] nums) {
    if(nums.length==0 )
        return 0;
     Arrays.sort(nums);
     int longest=1,currcount=0,last_smaller=Integer.MIN_VALUE;
     for(int i=0;i<nums.length;i++)
     {
        if(nums[i]-1==last_smaller)
        {
            currcount++;
            last_smaller=nums[i];
        }
        else if(nums[i]!=last_smaller)
        {
            currcount=1;
            last_smaller=nums[i];
        }
        longest=Math.max(longest,currcount);
     }
     return longest;
    }
}