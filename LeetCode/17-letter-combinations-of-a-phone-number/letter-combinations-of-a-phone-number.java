class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<>();

        if(digits.length()==0)
        {
            return ans;
        }
        StringBuilder output=new StringBuilder();
        int index=0;
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        solve(digits,output,index,ans,mapping);
        return ans;
    }
    private void solve(String digits,StringBuilder output,int index,List<String> ans,String[] mapping)
    {
        if(index>=digits.length())
        {
            ans.add(output.toString());
            return;
        }
        int number=digits.charAt(index)-'0';
        String value=mapping[number];

        for(int i=0;i<value.length();i++)
        {
            output.append(value.charAt(i));
            solve(digits,output,index+1,ans,mapping);
            output.deleteCharAt(output.length()-1);
        }
    }
}