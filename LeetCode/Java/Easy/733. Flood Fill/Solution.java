class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldcolor = image[sr][sc];
        if(oldcolor != color) dfs(image , sr , sc , oldcolor , color);
        return image;
    }
    public void dfs(int[][] image , int r , int c , int oldcolor , int newcolor){
        int m = image.length;
        int n = image[0].length;
        image[r][c] = newcolor;
        if(r - 1 >= 0 && image[r - 1][c] == oldcolor) dfs(image , r - 1 , c , oldcolor , newcolor);
        if(r + 1 < m && image[r + 1][c] == oldcolor) dfs(image , r + 1 , c , oldcolor , newcolor);
        if(c - 1 >= 0 && image[r][c - 1] == oldcolor) dfs(image , r , c - 1 , oldcolor , newcolor);
        if(c + 1 < n && image[r][c + 1] == oldcolor) dfs(image , r , c + 1 , oldcolor , newcolor);
    }
}
