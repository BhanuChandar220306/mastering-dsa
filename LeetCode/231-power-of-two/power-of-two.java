class Solution {
    public boolean isPowerOfTwo(int n) {
        int pow=n&(n-1);
        if( n>0 && pow==0)
            return true;
        else
            return false;
    }
}