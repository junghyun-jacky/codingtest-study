class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for(int i=0; i<computers.length; i++) {
            if(!visited[i]) {
                dfs(computers, i, visited);
                answer++;
            }
        }
        
        return answer;
    }
    
    private void dfs(int[][] computers, int i, boolean[] visited) {
        
        visited[i] = true;
        
        for(int j=0; j<computers.length; j++) {
            if(!visited[j] && computers[i][j] == 1) {
                dfs(computers, j, visited);
            }
        }
    }
}