class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1000000007;
        int n = s.length();
        long[] arr = new long[n+1];
        arr[0] = 1;
        int[] arr2 = new int[26];
        Arrays.fill(arr2,-1);
        for(int i = 1 ; i <= n ; i++){
            int ch = s.charAt(i-1) - 'a';
            arr[i] = (2 * arr[i-1]) % MOD;
            if(arr2[ch] != -1){
                arr[i] = (arr[i] - arr[arr2[ch]] + MOD) % MOD;
            }
            arr2[ch] = i - 1;
        }
        return (int)((arr[n] - 1 + MOD) % MOD);
    }
}