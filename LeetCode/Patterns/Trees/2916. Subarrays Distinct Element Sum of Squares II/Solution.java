class Solution{
    static final int MOD = 1_000_000_007;
    public int sumCounts(int[] nums){
        int n = nums.length;
        long[] sum = new long[4 * n];
        long[] sumSq = new long[4 * n];
        long[] lazy = new long[4 * n];
        int[] last = new int[100001];
        long ans = 0;
        for(int i = 0 ; i < n ; i++){
            int x = nums[i];
            int left = last[x];
            update(1, 0, n - 1 , left, i , 1 , sum , sumSq , lazy);
            ans = (ans + sumSq[1]) % MOD;
            last[x] = i + 1;
        }
        return (int) ans;
    }
    private void update(int node, int start , int end , int l , int r , long val, long[] sum , long[] sumSq , long[] lazy){
        if(l > end || r < start){
            return;
        }
        if(l <= start && end <= r){
            long len = end - start + 1L;
            sumSq[node] = (sumSq[node] + 2L * val % MOD * sum[node] + len * val % MOD * val) % MOD;
            sum[node] = (sum[node] + len * val) % MOD;
            lazy[node] = (lazy[node] + val) % MOD;
            return;
        }
        push(node, start , end , sum , sumSq, lazy);
        int mid = start + (end - start) / 2;
        update(node * 2, start , mid , l , r , val , sum , sumSq, lazy);
        update(node * 2 + 1 , mid + 1 , end , l , r , val , sum , sumSq , lazy);
        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
        sumSq[node] = (sumSq[node * 2] + sumSq[node * 2 + 1] % MOD);
    }
    private void push(int node , int start , int end , long[] sum , long[] sumSq , long[] lazy){
        if(lazy[node] == 0 || start == end){
            return;
        }
        int mid = start + (end - start) / 2;
        long val = lazy[node];
        apply(node * 2 , start , mid , val , sum , sumSq , lazy);
        apply(node * 2 + 1 , mid + 1 , end , val , sum , sumSq , lazy);
        lazy[node] = 0;
    }
    private void apply(int node , int start , int end , long val , long[] sum , long[] sumSq , long[] lazy){
        long len = end - start + 1L;
        sumSq[node] = (sumSq[node] + 2L * val % MOD * sum[node] + len * val % MOD * val) % MOD;
        sum[node] = (sum[node] + len * val) % MOD;
        lazy[node] = (lazy[node] + val) % MOD;
    }
}
  
