class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=0;

        for(int pile:piles)
        {
            high=Math.max(pile,high);
        }
        int res=high;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(canEat(piles,mid,h))
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
    public boolean canEat(int[] piles,int mid,int h)
    {
        long total=0;
        for(int pile:piles)
        {
            total+=(pile+mid-1)/mid;

        }
        return total<=h;
    }
}