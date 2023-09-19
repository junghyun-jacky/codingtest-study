import java.util.*;

class Solution {
    
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    
    // 인접 리스트에 그래프 저장
    public int solution(int n, int[][] edge) {
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 간선 연결
        for (int[] i : edge) {
			int v = i[0];
			int w = i[1];
			graph.get(v).add(w);
			graph.get(w).add(v);
		}
        
        boolean[] visited = new boolean[n + 1];
        return bfs(graph, n, visited);
    }
    
    // 최대 거리 탐색
    public int bfs(ArrayList<ArrayList<Integer>> graph, int n, boolean[] visited) {
        
        Queue<int[]> queue = new LinkedList<>();
        int answer = 0; // 가장 멀리 떨어진 노드의 개수
        
        // 큐: [노드, 1번 노드로부터 거리]인 배열 형태
        queue.add(new int[] {1, 0});
        visited[1] = true;
        int maxDepth = 0;
        
        while(!queue.isEmpty()) {
            int[] arr = queue.poll();
            int v = arr[0];
            int depth = arr[1];
            
            if(maxDepth == depth) {
                answer++;
            } else if(maxDepth < depth) {
                maxDepth = depth;
                answer = 1;
            }
            
            for(int i=0; i<graph.get(v).size(); i++) {
                int w = graph.get(v).get(i); //인접 정점
                if (!visited[w]) {
                    queue.add(new int[] {w, depth + 1});
                    visited[w] = true;
                }
            }
        }      
        return answer;
    }
}