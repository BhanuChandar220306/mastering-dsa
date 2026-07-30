class Solution {
    public int maxArea(int[] height) {
        int maxarea,area;
        area=maxarea=0;
        int i=0;
        int j=height.length-1;
        while(i<j)
        {
            int dist=j-i;
            area=dist*Math.min(height[i],height[j]);
            if(area>maxarea)
                maxarea=area;
            if(height[j]<height[i]) 
                j--;
            else
                i++;
        }
        return maxarea;
    }
}