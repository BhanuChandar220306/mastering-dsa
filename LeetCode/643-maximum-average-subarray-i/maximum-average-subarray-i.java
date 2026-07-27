class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum=0;
        int i=0; 
        int j=0;
        while(j<k)
        {
            sum+=nums[j];
            j++;
        }
        int maxsum=sum;
        while(j<nums.length)
        {
            sum+=nums[j];
            sum-=nums[i];
            maxsum=Math.max(maxsum,sum);
            i++;
            j++;
        }
        return (double)maxsum/k;
    }
}