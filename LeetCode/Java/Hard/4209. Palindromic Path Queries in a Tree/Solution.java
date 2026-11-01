import java.util.*;

class Solution {
    private List<Integer>[] tree;
    private int[] parent, depth, size, heavy;
    private int[] head, pos, value;
    private int timer;
    private SegmentTree seg;

    public List<Boolean> palindromePath(
            int n, int[][] edges, String s, String[] queries) {

        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            tree[e[0]].add(e[1]);
            tree[e[1]].add(e[0]);
        }

        parent = new int[n];
        depth = new int[n];
        size = new int[n];
        heavy = new int[n];
        head = new int[n];
        pos = new int[n];
        value = new int[n];

        Arrays.fill(heavy, -1);

        for (int i = 0; i < n; i++) {
            value[i] = 1 << (s.charAt(i) - 'a');
        }

        dfs(0, -1);
        decompose(0, 0);

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[pos[i]] = value[i];
        }

        seg = new SegmentTree(arr);
        List<Boolean> answer = new ArrayList<>();

        for (String q : queries) {
            String[] parts = q.split(" ");

            if (parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);

                value[u] = 1 << (c - 'a');
                seg.update(pos[u], value[u]);

            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);

                int mask = queryPath(u, v);
                answer.add((mask & (mask - 1)) == 0);
            }
        }

        return answer;
    }

    private int dfs(int u, int p) {
        parent[u] = p;
        size[u] = 1;
        int maxSize = 0;

        for (int v : tree[u]) {
            if (v == p) continue;

            depth[v] = depth[u] + 1;
            int childSize = dfs(v, u);
            size[u] += childSize;

            if (childSize > maxSize) {
                maxSize = childSize;
                heavy[u] = v;
            }
        }

        return size[u];
    }

    private void decompose(int u, int h) {
        head[u] = h;
        pos[u] = timer++;

        if (heavy[u] != -1) {
            decompose(heavy[u], h);
        }

        for (int v : tree[u]) {
            if (v == parent[u] || v == heavy[u]) continue;
            decompose(v, v);
        }
    }

    private int queryPath(int u, int v) {
        int mask = 0;

        while (head[u] != head[v]) {
            if (depth[head[u]] < depth[head[v]]) {
                int temp = u;
                u = v;
                v = temp;
            }

            mask ^= seg.query(pos[head[u]], pos[u]);
            u = parent[head[u]];
        }

        if (depth[u] > depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        mask ^= seg.query(pos[u], pos[v]);

        return mask;
    }

    static class SegmentTree {
        int[] tree;
        int n;

        SegmentTree(int[] arr) {
            n = arr.length;
            tree = new int[4 * n];
            build(1, 0, n - 1, arr);
        }

        private void build(int node, int l, int r, int[] arr) {
            if (l == r) {
                tree[node] = arr[l];
                return;
            }

            int mid = (l + r) / 2;
            build(node * 2, l, mid, arr);
            build(node * 2 + 1, mid + 1, r, arr);

            tree[node] = tree[node * 2] ^ tree[node * 2 + 1];
        }

        void update(int idx, int val) {
            update(1, 0, n - 1, idx, val);
        }

        private void update(
                int node, int l, int r, int idx, int val) {

            if (l == r) {
                tree[node] = val;
                return;
            }

            int mid = (l + r) / 2;

            if (idx <= mid) {
                update(node * 2, l, mid, idx, val);
            } else {
                update(node * 2 + 1, mid + 1, r, idx, val);
            }

            tree[node] = tree[node * 2] ^ tree[node * 2 + 1];
        }

        int query(int ql, int qr) {
            return query(1, 0, n - 1, ql, qr);
        }

        private int query(
                int node, int l, int r, int ql, int qr) {

            if (ql <= l && r <= qr) {
                return tree[node];
            }

            int mid = (l + r) / 2;
            int result = 0;

            if (ql <= mid) {
                result ^= query(node * 2, l, mid, ql, qr);
            }

            if (qr > mid) {
                result ^= query(node * 2 + 1, mid + 1, r, ql, qr);
            }

            return result;
        }
    }
}