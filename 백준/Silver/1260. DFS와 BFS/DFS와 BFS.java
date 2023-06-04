import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 낮은 정점부터 방문
 * 1. N, M, V 를 입력받는다.
 * 2. N+1 의 크기만큼 arr과 visited의 크기를 할당해준다.
 * 3. dfs 와 bfs 를 구현한다.
 * 4. 방문 정점을 StringBuilder로 저장하여 출력한다.
 */

public class Main {

    static StringBuilder sb = new StringBuilder();

    static int N, M, V;

    static boolean[] visited;

    static int[][] arr;   // 노드 간의 간선 표현

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];
        visited = new boolean[N+1];

        // 노드 간의 간선을 표현해주기 위한 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] =  1;
        }

        dfs(V);

        sb.append("\n");

        visited = new boolean[N+1];
        bfs(V);

        System.out.println(sb);
    }

    private static void dfs(int V) {
        visited[V] = true;
        sb.append(V).append(" ");

        for (int i = 1; i <= N; i++) {
            if(arr[V][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int V) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(V);
        visited[V] = true;

        while(!queue.isEmpty()) {
            V = queue.poll();
            sb.append(V).append(" ");

            for(int i = 1 ; i <= N ; i++) {
                if(arr[V][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

}
