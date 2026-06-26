class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1;
        int high=0;
        for(int num:nums)
        {
            high=Math.max(high,num);
        }
        int res=high;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(isDivisor(nums,mid,threshold))
            {
                res=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return res;
    }
    public boolean isDivisor(int arr[],int k,int threshold)
    {
        int sum=0;
        for(int x:arr)
        {
            sum+=(x+k-1)/k;
        }
        return sum<=threshold;
    }
}