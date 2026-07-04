class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> arr=new ArrayList<Integer>();
        int i=0;
        while(i<nums.length)
        {
            int correct=nums[i]-1;
            if(nums[i]!=nums[correct])
                swap(nums,i,correct);
            else
                i++;
        }
        for(int index=0;index<nums.length;index++)
        {
            if(nums[index]!=index+1)
                arr.add(index+1);
        }
        return arr;
    }

    public void swap(int nums[],int first,int second)
    {
        int temp=nums[first];
        nums[first]=nums[second];
        nums[second]=temp;
    }
}