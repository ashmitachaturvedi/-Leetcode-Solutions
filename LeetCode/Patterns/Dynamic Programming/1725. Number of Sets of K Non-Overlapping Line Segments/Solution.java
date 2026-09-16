class Solution {
    static final int MOD = 1_000_000_007;

    public int numberOfSets(int n, int k) {
        n = n + k - 1;
        int r = 2 * k;

        long ans = 1;

        for (int i = 1; i <= r; i++) {
            ans = ans * (n - r + i) % MOD;
            ans = ans * modInverse(i) % MOD;
        }

        return (int) ans;
    }

    private long modInverse(long x) {
        return power(x, MOD - 2);
    }

    private long power(long a, long b) {
        long result = 1;

        while (b > 0) {
            if ((b & 1) == 1) {
                result = result * a % MOD;
            }

            a = a * a % MOD;
            b >>= 1;
        }

        return result;
    }
}