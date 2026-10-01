class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int r = 0 ; r < m ; r++){
            for(int c = 0 ; c < n ; c++){
                if(grid[r][c] == '1'){
                    DFS(grid,r,c);
                    count++;
                }
            }
        }
        return count;
    }
    public void DFS(char[][] grid , int r , int c){
        int m = grid.length;
        int n = grid[0].length;
        grid[r][c] = '0';
        if(r - 1 >= 0 && grid[r - 1][c] == '1') DFS(grid,r-1,c);
        if(c + 1 < n && grid[r][c + 1] == '1') DFS(grid,r,c+1);
        if(r + 1 < m && grid[r + 1][c] == '1') DFS(grid,r+1,c);
        if(c - 1 >= 0 && grid[r][c - 1] == '1') DFS(grid, r , c - 1);
    }
}