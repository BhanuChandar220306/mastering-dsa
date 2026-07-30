class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=0;i<m+n;i++)
        {
            if(i<m)
            {}
            else
            {
                nums1[i]=nums2[i-m];
            }
        }
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }
}