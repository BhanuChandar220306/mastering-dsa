class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> output=new ArrayList<>();
        solve(nums,0,output,ans);
        return ans;
    }
    public static void solve(int nums[],int index,List<Integer> output,List<List<Integer>> ans)
    {
        if(index>=nums.length)
        {
            ans.add(new ArrayList<>(output));
            return;
        }
        output.add(nums[index]);
        solve(nums,index+1,output,ans);
        output.remove(output.size()-1);
        while(index+1<nums.length && nums[index]==nums[index+1])
        {
            index++;
        }
        solve(nums,index+1,output,ans);
    }

}