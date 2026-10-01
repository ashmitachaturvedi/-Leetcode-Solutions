// class Solution {
//     public int numIslands(char[][] grid) {
//         int m = grid.length;
//         int n = grid[0].length;
//         int count = 0;
//         for(int r = 0 ; r < m ; r++){
//             for(int c = 0 ; c < n ; c++){
//                 if(grid[r][c] == '1'){
//                     DFS(grid,r,c);
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }
//     public void DFS(char[][] grid , int r , int c){
//         int m = grid.length;
//         int n = grid[0].length;
//         grid[r][c] = '0';
//         if(r - 1 >= 0 && grid[r - 1][c] == '1') DFS(grid,r-1,c);
//         if(c + 1 < n && grid[r][c + 1] == '1') DFS(grid,r,c+1);
//         if(r + 1 < m && grid[r + 1][c] == '1') DFS(grid,r+1,c);
//         if(c - 1 >= 0 && grid[r][c - 1] == '1') DFS(grid, r , c - 1);
//     }
// }

class Solution{
    public int numIslands(char[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int r = 0 ; r < m; r++){
            for(int c = 0 ; c < n ; c++){
                if(grid[r][c] == '1'){
                BFS(grid,r,c);
                count++;
                }
            }
        }
        return count;
    }
    public void BFS(char[][] grid , int r , int c){
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});
        grid[r][c] = '0';
        while(!q.isEmpty()){
            int[] current =  q.poll();
            int row = current[0];
            int col = current[1];

            if(row - 1 >= 0 && grid[row - 1][col] == '1'){
                grid[row - 1][col] = '0';
                q.add(new int[]{row - 1 , col});
            }
            if(col + 1 < n && grid[row][col + 1] == '1'){
                grid[row][col + 1] = '0';
                q.add(new int[]{row , col + 1});
            }
            if(row + 1 < m && grid[row + 1][col] == '1'){
                grid[row + 1][col] = '0';
                q.add(new int[]{row + 1, col});
            }
            if(col - 1 >= 0 && grid[row][col - 1] == '1'){
                grid[row][col - 1] = '0';
                q.add(new int[]{row , col - 1});
            }
        }
    }
}