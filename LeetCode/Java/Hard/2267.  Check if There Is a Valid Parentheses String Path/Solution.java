class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if((m + n - 1) % 2 != 0){
            return false;
        }
        return dfs(grid , 0 , 0 , 0);
    }
    private boolean dfs(char[][] grid , int row , int col , int balance){
        int m = grid.length;
        int n = grid[0].length;
        if(grid[row][col] == '('){
            balance++;
        }else{
            balance--;
        }
        if(balance < 0) return false;
        if(row == m - 1 && col == n - 1) return balance == 0;
        if(row + 1 < m && dfs(grid , row + 1 , col , balance)) return true;
        if(col + 1 < n && dfs(grid , row , col + 1 , balance)) return true;
        return false;
    }
}