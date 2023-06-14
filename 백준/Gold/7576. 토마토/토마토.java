import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int M, N;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[][] map;

    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        // 토마토 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // 익은 토마토인 경우 미리 queue에 넣어줌
                if(map[i][j] == 1) {
                    queue.add(new int[] {i, j});
                }
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    // 토마토가 안 익었으면
                    if(map[nx][ny] == 0) {
                        // 익은 날짜를 얻기 위해 그 전 값에서 + 1
                        map[nx][ny] = map[x][y] + 1;
                        // 익은 토마토 추가
                        queue.add(new int[] {nx, ny});
                    }
                }
            }
        }

        int result = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 안 익은 토마토가 있으먄
                if(map[i][j] == 0) {
                    return -1;
                }
                result = Math.max(result, map[i][j]);
            }
        }
        // 이미 토마토가 다 익어있는 경우
        if(result == 1) {
            return 0;
        }
        // 걸린 일수 -1
        else {
            return result -1;
        }
    }

}