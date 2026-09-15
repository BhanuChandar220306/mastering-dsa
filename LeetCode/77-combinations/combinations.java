class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> current=new ArrayList<>();
        solve(1,n,k,current,ans);
        return ans;
    }
    public static void solve(int index,int n,int k,List<Integer> current,List<List<Integer>> ans)
    {
        if(current.size()==k)
        {
            ans.add(new ArrayList<>(current));
            return;
        }
        for(int i=index;i<=n;i++)
        {
            current.add(i);
            solve(i+1,n,k,current,ans);
            current.remove(current.size()-1);
        }
    }
}