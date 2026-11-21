
class Solution {

    public int[] findSubtreeSizes(int[] parent, String s) {

        int n = parent.length;

        // Step 1: Build original tree
        ArrayList<Integer>[] tree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            tree[parent[i]].add(i);
        }

        // Step 2: Maintain 26 character stacks
        ArrayList<Integer>[] path = new ArrayList[26];

        for (int i = 0; i < 26; i++) {
            path[i] = new ArrayList<>();
        }

        int[] ans = new int[n];

        // Step 3: Iterative DFS
        // Positive event = Enter node
        // Negative event = Exit node
        int[] stack = new int[2 * n + 5];

        int top = 0;
        stack[top++] = 1; // Enter node 0 (0 + 1)

        while (top > 0) {

            int event = stack[--top];

            if (event > 0) {

                // ENTER
                int node = event - 1;

                int ch = s.charAt(node) - 'a';

                ans[node] = 1;

                // Push current node onto character stack
                path[ch].add(node);

                // Schedule exit after all children
                stack[top++] = -(node + 1);

                // Process children
                for (int i = tree[node].size() - 1; i >= 0; i--) {

                    int child = tree[node].get(i);

                    stack[top++] = child + 1;
                }

            } else {

                // EXIT (Postorder)
                int node = -event - 1;

                int ch = s.charAt(node) - 'a';

                ArrayList<Integer> list = path[ch];

                int newParent;

                if (list.size() >= 2) {

                    // Closest same-character ancestor
                    newParent = list.get(list.size() - 2);

                } else {

                    // No matching ancestor
                    newParent = parent[node];
                }

                // Add current subtree size to its final parent
                if (newParent != -1) {
                    ans[newParent] += ans[node];
                }

                // Backtrack
                list.remove(list.size() - 1);
            }
        }

        return ans;
    }
}
