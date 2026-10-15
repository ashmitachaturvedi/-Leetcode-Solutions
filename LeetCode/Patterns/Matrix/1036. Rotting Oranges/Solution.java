class Solution {
    public int orangesRotting(int[][] grid) {
          int m = grid.length;
          int n = grid[0].length;
          Queue<int[]> q = new LinkedList<>();
          int freshcount = 0;
          int time = -1;
          for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 1){
                    freshcount++;
                }
                else if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }
            }
        }
        q.offer(new int[]{-1,-1});
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            if(r == -1 && c == -1){
                time++;
                if(!q.isEmpty()){
                    q.offer(new int[]{-1,-1});
                }
            }
            else{
            if(r - 1 >= 0 && grid[r - 1][c] == 1){
                grid[r - 1][c] = 2;
                freshcount--;
                q.offer(new int[]{r - 1,c});
            }
            if(r + 1 < m && grid[r + 1][c] == 1){
                grid[r + 1][c] = 2;
                freshcount--;
                q.offer(new int[]{r + 1,c});
            }
            if(c - 1 >= 0 && grid[r][c - 1] == 1){
                grid[r][c - 1] = 2;
                freshcount--;
                q.offer(new int[]{r, c - 1});
            }
            if(c + 1 < n && grid[r][c + 1] == 1){
                grid[r][c + 1] = 2;
                freshcount--;
                q.offer(new int[]{r, c + 1});
            }
            }
        }
        return freshcount == 0 ? time : -1;
    }
}
