import java.util.*;

class Solution {
    
    static int maxCount;
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        maxCount = Integer.MIN_VALUE;
        
        for(int i=0; i<dungeons.length; i++) {
            dfs(k, dungeons, visited);
        }
                
        return maxCount;
    }
    
    public static void dfs(int k, int[][] dungeons, boolean[] visited) {
        int count = 0;
        
        for(int i = 0; i < visited.length; i++) {
            if(visited[i]) {
                count++;
            }
        }
        if(maxCount <= count) {
            maxCount = count;
        }
        
         for(int i = 0; i < dungeons.length; i++) {
            if(!visited[i]) {
                if(dungeons[i][0] <= k) {
                    visited[i] = true;
                    k -= dungeons[i][1];
                    dfs(k, dungeons, visited);
                    k += dungeons[i][1];
                    visited[i] = false;
                }
            }
        }
    }
}