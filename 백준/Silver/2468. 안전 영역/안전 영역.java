import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] Map;      // 지도
    static int[][] transMap; // 변형 지도
    static boolean[][] visited;

    // right, down, left, up
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int count;   // 안전지역 개수
    static int maxDistrictNum; // 최대값 (결과)

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        Map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                Map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        maxDistrictNum = 1;

        // 높이 i (1~100)
        for (int i = 1; i <= 100; i++) {
            transMap = new int[N][N];
            count = 0;

            visited = new boolean[N][N];

            // 높이 이하면 0, 아니면 1
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    if(Map[x][y] <= i) {
                        transMap[x][y] = 0;
                    } else {
                        transMap[x][y] = 1;
                    }
                }
            }

            // dfs 탐색
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    if(transMap[x][y] == 1 && !visited[x][y]) {
                        dfs(x, y);
                        count++;
                    }
                }
            }
            maxDistrictNum = Math.max(maxDistrictNum, count);
        }
        System.out.println(maxDistrictNum);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 배열을 넘어가면 X
            if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
                // nx, ny 가 0이면 X, 방문한 배열이면 X
                if (transMap[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }

}