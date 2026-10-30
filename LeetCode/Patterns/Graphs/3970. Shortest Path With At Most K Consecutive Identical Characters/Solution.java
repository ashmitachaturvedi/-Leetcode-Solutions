import java.util.*;

class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
        }

        if (k < 1) {
            return -1;
        }

        long[][] dist = new long[n][k + 1];
        for (long[] row : dist) {
            Arrays.fill(row, Long.MAX_VALUE);
        }

        // State: {distance, node, consecutiveCount}
        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );

        dist[0][1] = 0;
        pq.offer(new long[]{0, 0, 1});

        while (!pq.isEmpty()) {
            long[] current = pq.poll();

            long cost = current[0];
            int node = (int) current[1];
            int count = (int) current[2];

            if (cost != dist[node][count]) {
                continue;
            }

            if (node == n - 1) {
                return (int) cost;
            }

            for (int[] next : graph[node]) {
                int neighbor = next[0];
                int weight = next[1];

                int newCount;

                if (labels.charAt(node) == labels.charAt(neighbor)) {
                    newCount = count + 1;
                } else {
                    newCount = 1;
                }

                if (newCount > k) {
                    continue;
                }

                long newCost = cost + weight;

                if (newCost < dist[neighbor][newCount]) {
                    dist[neighbor][newCount] = newCost;

                    pq.offer(new long[]{
                        newCost, neighbor, newCount
                    });
                }
            }
        }

        return -1;
    }
}