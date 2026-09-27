class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(board[i],'.');
        }
        int[] leftrow=new int[n];
        int[] upperdiagonal=new int[2*n-1];
        int[] lowerdiagonal=new int[2*n-1];
        solve(0,board,ans,leftrow,upperdiagonal,lowerdiagonal,n);
        return ans;
    }
    public void solve(int col,char[][] board,List<List<String>> ans,int[] leftrow,int[] upperdiagonal,int[] lowerdiagonal,int n)
    {
        if(col==n)
        {
            List<String> currentboard=new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                currentboard.add(new String(board[i]));
            }
            ans.add(currentboard);
            return;
        }
        for(int row=0;row<n;row++)
        {
            if(leftrow[row]==0 && lowerdiagonal[row+col]==0 && upperdiagonal[n-1+col-row]==0)
            {
                board[row][col]='Q';
                leftrow[row]=1;
                lowerdiagonal[row+col]=1;
                upperdiagonal[n-1+col-row]=1;
                solve(col+1,board,ans,leftrow,upperdiagonal,lowerdiagonal,n);
                board[row][col]='.';
                leftrow[row]=0;
                lowerdiagonal[row+col]=0;
                upperdiagonal[n-1+col-row]=0;
            }
        }
    }
}