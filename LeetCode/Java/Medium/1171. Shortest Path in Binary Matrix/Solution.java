class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return -1;

        int[][] dist = new int[n][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        int[][] dirs = {
                { -1, -1 }, { -1, 0 }, { -1, 1 },
                { 0, -1 }, { 0, 1 },
                { 1, -1 }, { 1, 0 }, { 1, 1 }
        };
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[0], b[0]));

        dist[0][0] = 1;
        pq.offer(new int[] { 1, 0, 0 });

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            int d = curr[0];
            int r = curr[1];
            int c = curr[2];
            if (d != dist[r][c]) {
                continue;
            }

            if (r == n - 1 && c == n - 1) {
                return d;
            }

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < n &&
                        nc >= 0 && nc < n &&
                        grid[nr][nc] == 0) {

                    int newDist = d + 1;

                    if (newDist < dist[nr][nc]) {
                        dist[nr][nc] = newDist;
                        pq.offer(new int[] { newDist, nr, nc });
                    }
                }
            }
        }

        return -1;
    }
}

// class Solution {
//     public int shortestPathBinaryMatrix(int[][] grid) {
//         int n = grid.length;
//         if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
//         Queue<int[]> q = new LinkedList<>();
//         q.offer(new int[]{0,0,1});
//         grid[0][0] = 1;
//         int[][] dirs = {
//             {-1,-1} , {-1,0} , {-1,1} ,
//             {0,-1} ,           {0,1} ,
//             {1,-1} , {1,0} , {1,1}
//             };
//         while(!q.isEmpty()){
//             int[] curr = q.poll();
//             int r = curr[0];
//             int c = curr[1];
//             int dist = curr[2];
//             if(r == n - 1 &&  c == n - 1){
//                 return dist;
//             }
//             for(int[] dir : dirs){
//                 int nr = r + dir[0];
//                 int nc = c + dir[1];
//                 if(nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 0){
//                     q.offer(new int[]{nr,nc,dist + 1});
//                     grid[nr][nc] = 1;
//                 }
//             }
//         }
//         return -1;
//     }
// }ine