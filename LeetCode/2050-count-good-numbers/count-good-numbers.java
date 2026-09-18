class Solution {
    private static final long MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        long evenPositions = (n + 1) / 2;
        long oddPositions = n / 2;

        long evenWays = power(5, evenPositions);
        long oddWays = power(4, oddPositions);

        return (int) ((evenWays * oddWays) % MOD);
    }

    // Recursive helper function for Binary Exponentiation
    private long power(long base, long exp) {
        // Base Case
        if (exp == 0) {
            return 1;
        }

        // Divide: compute base^(exp / 2) recursively
        long half = power(base, exp / 2);
        long halfSquared = (half * half) % MOD;

        // Combine: if exp is odd, multiply by base once more
        if (exp % 2 != 0) {
            return (halfSquared * (base % MOD)) % MOD;
        }

        return halfSquared;
    }
}