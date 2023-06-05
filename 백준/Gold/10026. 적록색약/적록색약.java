import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int count;   // 인접지역 개수

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean[][] visited;
    static String[][] Map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        Map = new String[N][N];

        // Map 입력받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < N; j++) {
                Map[i][j] = line.substring(j, j+1);
            }
        }

        // 적록색약이 아닐 때
        visited = new boolean[N][N];
        count = 0;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if(!visited[x][y]) {
                    dfsRGB(x, y);
                    count++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(count).append(" ");

        
        // 적록색약일 때
        visited = new boolean[N][N];
        count = 0;

        // G를 R로 치환
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(Map[i][j].equals("G")) {
                    Map[i][j] = "R";
                }
            }
        }

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if(!visited[x][y]) {
                    dfsRB(x, y);
                    count++;
                }
            }
        }
        sb.append(count);

        System.out.println(sb);

    }

    private static void dfsRGB(int x, int y) {
        visited[x][y] = true;
        String tmpString = Map[x][y];

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 배열을 넘어가면 X
            if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
                // 변경된 x, y 가 0이면 X, 방문한 배열이면 안됨
                if (Map[nx][ny].equals(tmpString) && !visited[nx][ny]) {
                    dfsRGB(nx, ny);
                }
            }
        }
    }

    private static void dfsRB(int x, int y) {
        visited[x][y] = true;
        String tmpString = Map[x][y];

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 배열을 넘어가면 X
            if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
                // 변경된 x, y 가 0이면 X, 방문한 배열이면 안됨
                if (Map[nx][ny].equals(tmpString) && !visited[nx][ny]) {
                    dfsRB(nx, ny);
                }
            }
        }
    }
}