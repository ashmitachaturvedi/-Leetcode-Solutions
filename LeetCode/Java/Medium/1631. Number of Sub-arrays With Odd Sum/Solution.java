
class Solution {
    public int numOfSubarrays(int[] arr) {

        int MOD = 1000000007;

        long even = 1;
        long odd = 0;

        long ans = 0;

        int sum = 0;

        for (int num : arr) {

            sum += num;

            if (sum % 2 == 0) {

                // Current prefix is even
                ans = (ans + odd) % MOD;
                even++;

            } else {

                // Current prefix is odd
                ans = (ans + even) % MOD;
                odd++;
            }
        }

        return (int) ans;
    }
}
