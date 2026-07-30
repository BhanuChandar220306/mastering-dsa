class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=0;
        int high=0;
        for(int x:weights)
        {
            low=Math.max(x,low);
            high+=x;
        }
        int res=high;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(isCapacity(weights,mid,days))
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
    
    public boolean isCapacity(int weights[],int capacity,int days)
    {
        int requireddays=1;
        int currentweight=0;
        for(int w:weights)
        {
            if(currentweight+w>capacity)
            {
                requireddays++;
                currentweight=w;
            }
            else
            {
                currentweight+=w;
            }
        }
        return requireddays<=days;
    }
}