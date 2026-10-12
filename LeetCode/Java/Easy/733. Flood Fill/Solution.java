// class Solution {
//     public int[][] floodFill(int[][] image, int sr, int sc, int color) {
//         int oldcolor = image[sr][sc];
//         if(oldcolor != color) dfs(image , sr , sc , oldcolor , color);
//         return image;
//     }
//     public void dfs(int[][] image , int r , int c , int oldcolor , int newcolor){
//         int m = image.length;
//         int n = image[0].length;
//         image[r][c] = newcolor;
//         if(r - 1 >= 0 && image[r - 1][c] == oldcolor) dfs(image , r - 1 , c , oldcolor , newcolor);
//         if(r + 1 < m && image[r + 1][c] == oldcolor) dfs(image , r + 1 , c , oldcolor , newcolor);
//         if(c - 1 >= 0 && image[r][c - 1] == oldcolor) dfs(image , r , c - 1 , oldcolor , newcolor);
//         if(c + 1 < n && image[r][c + 1] == oldcolor) dfs(image , r , c + 1 , oldcolor , newcolor);
//     }
// }

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        if (oldColor != color) {
            bfs(image, sr, sc, oldColor, color);
        }
        return image;
    }
    public void bfs(int[][] image, int sr, int sc,int oldColor, int newColor) {
        int m = image.length;
        int n = image[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        image[sr][sc] = newColor;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == oldColor) {
                    image[nr][nc] = newColor;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }
}