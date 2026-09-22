class Solution {
    static final int MOD = 1_000_000_007;

    int n, k;
    int[][] cnt;
    int[] prod;

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.n = nums.length;
        this.k = k;

        cnt = new int[4 * n][k];
        prod = new int[4 * n];

        build(1, 0, n - 1, nums);

        int[] ans = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {
            int index = queries[q][0];
            int value = queries[q][1];
            int start = queries[q][2];
            int x = queries[q][3];

            update(1, 0, n - 1, index, value);

            Node res = query(1, 0, n - 1, start, n - 1);

            ans[q] = res.cnt[x];
        }

        return ans;
    }

    void build(int node, int l, int r, int[] nums) {
        if (l == r) {
            int rem = nums[l] % k;
            prod[node] = rem;
            cnt[node][rem] = 1;
            return;
        }

        int mid = (l + r) / 2;

        build(node * 2, l, mid, nums);
        build(node * 2 + 1, mid + 1, r, nums);

        merge(node, node * 2, node * 2 + 1);
    }

    void update(int node, int l, int r, int index, int value) {
        if (l == r) {
            for (int i = 0; i < k; i++) {
                cnt[node][i] = 0;
            }

            int rem = value % k;

            prod[node] = rem;
            cnt[node][rem] = 1;

            return;
        }

        int mid = (l + r) / 2;

        if (index <= mid) {
            update(node * 2, l, mid, index, value);
        } else {
            update(node * 2 + 1, mid + 1, r, index, value);
        }

        merge(node, node * 2, node * 2 + 1);
    }

    void merge(int node, int left, int right) {
        for (int i = 0; i < k; i++) {
            cnt[node][i] = cnt[left][i];
        }

        int leftProd = prod[left];

        for (int rem = 0; rem < k; rem++) {
            int newRem = (leftProd * rem) % k;
            cnt[node][newRem] += cnt[right][rem];
        }

        prod[node] = (prod[left] * prod[right]) % k;
    }

    Node query(int node, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            return new Node(prod[node], cnt[node]);
        }

        int mid = (l + r) / 2;

        if (qr <= mid) {
            return query(node * 2, l, mid, ql, qr);
        }

        if (ql > mid) {
            return query(node * 2 + 1, mid + 1, r, ql, qr);
        }

        Node left = query(node * 2, l, mid, ql, qr);
        Node right = query(node * 2 + 1, mid + 1, r, ql, qr);

        return combine(left, right);
    }

    Node combine(Node left, Node right) {
        int[] resCnt = new int[k];

        for (int i = 0; i < k; i++) {
            resCnt[i] = left.cnt[i];
        }

        for (int i = 0; i < k; i++) {
            int rem = (left.prod * i) % k;
            resCnt[rem] += right.cnt[i];
        }

        int resProd = (left.prod * right.prod) % k;

        return new Node(resProd, resCnt);
    }

    class Node {
        int prod;
        int[] cnt;

        Node(int prod, int[] cnt) {
            this.prod = prod;
            this.cnt = cnt.clone();
        }
    }
}