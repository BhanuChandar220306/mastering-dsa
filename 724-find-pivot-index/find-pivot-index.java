class Solution {
    public int pivotIndex(int[] nums) {
        int n=nums.length;
        int lsum=0;
        int rsum=0;
        int prefix[]=new int[n];
        prefix[0]=nums[0];
        for(int i=1;i<n;i++)
        {
            prefix[i]=nums[i]+prefix[i-1];
        }
        for(int i=0;i<n;i++)
        {
            if(i==0)
            {
                lsum=0;
                rsum=prefix[n-1]-prefix[i];
            }
            else if(i==n-1)
            {
                rsum=0;
                lsum=prefix[n-1]-nums[i];
            }
            else
            {
                lsum=prefix[i-1];
                rsum=prefix[n-1]-prefix[i];
            }
            if(lsum==rsum)
            {
                return i;
            }
        }
        return -1;
    }
}