class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
       List<List<Integer>> results=new ArrayList<>();
       backtrack(k,n,1,new ArrayList<>(),results) ;
       return results;
    }
    private void backtrack(int k,int target,int start,List<Integer> current,List<List<Integer>> results)
    {
        if(current.size()==k)
        {
            if(target==0)
            {
                results.add(new ArrayList<>(current));
            }
            return;
        }
        for(int i=start;i<=9;i++)
        {
            if(i>target)
            {
                break;
            }
            current.add(i);
            backtrack(k,target-i,i+1,current,results);
            current.remove(current.size()-1);
        }
    }
}