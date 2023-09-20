import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int N;
    static int M;
    static int r, c, d;

    // right, down, left, up
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    // 로봇 청소기가 작동을 시작한 후 작동을 멈출 때까지 청소하는 칸의 개수
    static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        count = 0;
        cleaning(r, c, d);
        System.out.println(count);

    }

    // d가 0인 경우 북쪽, 1인 경우 동쪽, 2인 경우 남쪽, 3인 경우 서쪽
    private static void cleaning(int r, int c, int direction) {

        // 청소
        if (map[r][c] == 0) {
            map[r][c] = 2;
            count++;
        }

        // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우 (왼쪽부터 청소)
        boolean flag = false;
        int origin = direction;
        for (int i = 0; i < 4; i++) {
            int nd = (direction + 3) % 4; // 왼쪽으로 방향 전환 (북0 > 서3 > 남2 > 동1)
            int nx = r + dx[nd];
            int ny = c + dy[nd];

            // 청소가 안된 곳이 있으면 count++,  dfs
            if(nx > 0 && ny > 0 && nx < N && ny < M) {
                if(map[nx][ny] == 0) {
                    cleaning(nx, ny, nd);
                    flag = true;
                    break;
                }
            }
            direction = (direction + 3) % 4;
        }

        // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
        // 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
        if (!flag) {
            int nd = (origin + 2) % 4;
            int bx = r + dx[nd];
            int by = c + dy[nd];

            if(bx > 0 && by > 0 && bx < N && by < M) {
                if(map[bx][by] != 1) {
                    cleaning(bx, by, origin);
                }
            }
        }

    }
}