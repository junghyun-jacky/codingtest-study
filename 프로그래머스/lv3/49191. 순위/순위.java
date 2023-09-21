class Solution {
    public int solution(int n, int[][] results) {
        
        int answer = 0;
        int[][] graph = new int[n+1][n+1];
        
        for(int i=0; i<results.length; i++) {
            int a = results[i][0];
            int b = results[i][1];
            
            graph[a][b] = 1;    // 이긴 선수는 1
            graph[b][a] = -1;   // 진 선수는 -1
        }
        
        // 4 > 3 , 3 > 2 => 4 > 2
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                for(int k=1; k<=n; k++) {
                    if(graph[i][j] == 1 && graph[j][k] == 1) {
                        graph[i][k] = 1;
                        graph[k][i] = -1;
                    }
                    if(graph[i][j] == -1 && graph[j][k] == -1) {
                        graph[i][k] = -1;
                        graph[k][i] = 1;
                    }
                }
            }
        }
        
        // 선수 별 승패 수 집계
        for(int i=1; i<=n; i++) {
            int count = 0;
            for(int j=1; j<=n; j++) {
                if(graph[i][j] != 0) count++;
            }
            // 각 행에서 0이 아닌 값이 n-1개 일 때 순위 측정 가능
            if(count == n-1) answer++;
        }
        
        return answer;
    }
}