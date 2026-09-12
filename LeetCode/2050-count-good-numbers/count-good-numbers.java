class Solution {
    private static final long MOD=1_000_000_007;
    public int countGoodNumbers(long n) {
       long evenpositions=(n+1) /2;
       long oddpositions=n/2;
       long evenways=power(5,evenpositions);
       long oddways=power(4,oddpositions);
       return (int)((evenways*oddways)%MOD);
    }
    private long power(long base,long exp)
    {
        long result=1;
        base%=MOD;
        while(exp>0)
        {
            if((exp&1)==1)
            {
                result=(result*base)%MOD;
            }
            base=(base*base)%MOD;
            exp>>=1;
        }
        return result;
    }
}