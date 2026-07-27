class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int maxsum=0;
        int left=0;
        int right=nums.length-1;
        while(left<right)
        {
            int sum=nums[left]+nums[right];
            maxsum=Math.max(sum,maxsum);
            left++;
            right--;
        }
        return maxsum;
    }
}