class Solution {
    public int minMoves(String[] classroom, int energy) {
        
        int m = classroom.length;
        int n = classroom[0].length();

        int sr = 0, sc = 0;
        int litter = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (classroom[i].charAt(j) == 'S') {
                    sr = i;
                    sc = j;
                } else if (classroom[i].charAt(j) == 'L') {
                    litter++;
                }
            }
        }

        if (litter == 0) return 0;

        int[][] id = new int[m][n];
        for (int[] row : id)
            Arrays.fill(row, -1);

        int idx = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (classroom[i].charAt(j) == 'L') {
                    id[i][j] = idx++;
                }
            }
        }

        int totalMask = (1 << litter) - 1;

        // r, c, energy, mask
        Queue<int[]> q = new LinkedList<>();

        boolean[][][][] visited =
            new boolean[m][n][energy + 1][1 << litter];

        q.offer(new int[]{sr, sc, energy, 0});
        visited[sr][sc][energy][0] = true;

        int[][] dir = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        int moves = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int[] cur = q.poll();

                int r = cur[0];
                int c = cur[1];
                int e = cur[2];
                int mask = cur[3];

                if (mask == totalMask)
                    return moves;

                if (e == 0)
                    continue;

                for (int[] d : dir) {

                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr < 0 || nr >= m ||
                        nc < 0 || nc >= n)
                        continue;

                    if (classroom[nr].charAt(nc) == 'X')
                        continue;

                    int ne = e - 1;
                    int nmask = mask;

                    if (classroom[nr].charAt(nc) == 'L') {
                        nmask |= (1 << id[nr][nc]);
                    }

                    if (classroom[nr].charAt(nc) == 'R') {
                        ne = energy;
                    }

                    if (!visited[nr][nc][ne][nmask]) {

                        visited[nr][nc][ne][nmask] = true;

                        q.offer(new int[]{
                            nr, nc, ne, nmask
                        });
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}