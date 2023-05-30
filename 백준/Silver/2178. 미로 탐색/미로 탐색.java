import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    // to search down, right, up, left
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static boolean[][] visited; // 방문기록 저장 배열
    static int[][] A;       // 데이터 저장 2차원 행렬
    static int N, M;            // N - row, M - column

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        visited = new boolean[N][M];

        // 데이터에 따른 A 배열 초기화
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken(); // 공백이 없으므로 줄 단위로 받아옴
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(line.substring(j, j+1));
            }
        }
        BFS(0,0);
        System.out.println(A[N-1][M-1]);
    }

    private static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i,j});

        while(!queue.isEmpty()) {
            int now[] = queue.poll(); // 현재 자리 체크
            visited[i][j] = true;     // 방문함
            for (int k = 0; k < 4; k++) { // 상하좌우 탐색
                int x = now[0] + dx[k];   // ex) k가 0일 때 dx: 현재 x값 그대로
                int y = now[1] + dy[k];   // ex) k가 0일 때 dy: 현재 y값 + 1  -> down

                // 유효한 좌표인지 검사
                // 배열을 넘어가면 X
                if(x >= 0 && y >= 0 && x < N && y < M) {
                    // 변경된 x, y 가 0이면 X, 방문한 배열이면 안됨
                    if(A[x][y] != 0 && !visited[x][y] ) {
                        visited[x][y] = true;   // 방문 처리
                        A[x][y] = A[now[0]][now[1]] + 1;    // depth 정보를 저장하기 위해 데이터를 +1 해줌
                        queue.add(new int[] {x,y});
                    }
                }
            }
        }
    }

}
