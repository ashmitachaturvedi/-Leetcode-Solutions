// class Solution {
//     public int findCircleNum(int[][] isConnected) {
//         int n = isConnected.length;
//         boolean[] visited = new boolean[n];
//         int count = 0;
//         for(int i = 0 ; i < n ; i++){
//             if(!visited[n]){
//             BFS(isConnected, i, visited);
//             count++;
//         }
//         }
//         return count;
//     }
//     public void BFS(int[][] isConnected, int src, boolean[] visited){
//         Queue<Integer> q = new LinkedList<>();
//         q.offer(src);
//         visited[src] = true;
//         while(!q.isEmpty()){
//             int u = q.poll();
//         for(int v = 0 ; v < isConnected.length ; v++){
//             if(isConnected[u][v] == 1 && !visited[v]){
//                 visited[v] = true;
//                 q.offer(v);
//             }
//         }
//         }
//     }
// }

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                DFS(isConnected, i, visited);
                count++;
            }
        }
        return count;
    }
    public void DFS(int[][] isConnected, int src, boolean[] visited) {
        visited[src] = true;
        for (int neighbor = 0; neighbor < isConnected.length; neighbor++) {
            if (visited[neighbor] == false && isConnected[src][neighbor] == 1) {
                DFS(isConnected, neighbor, visited);
            }
        }
    }
}