import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
 
    public static int count = 0;

    public static void dfs(int[][] graph, boolean[] visited, int x) {
        if(visited[x]) return;
        
        visited[x] = true;
        count++;
        
        for (int i = 0; i < graph[x].length; i++) {
            if(graph[x][i]==1 && !visited[i])
                dfs(graph,visited,i);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int computer = Integer.parseInt(br.readLine());
        int line = Integer.parseInt(br.readLine());

        int[][] graph = new int[computer + 1][computer + 1];
        boolean[] visited = new boolean[computer + 1];

        StringTokenizer st;
        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            graph[x1][x2] = 1;
            graph[x2][x1] = 1;
        }
        dfs(graph,visited,1); 
        System.out.println(count-1);
    }
}
