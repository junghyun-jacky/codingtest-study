import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    // to search down, right, up, left
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static boolean[][] visited; // 방문기록 저장 배열
    static int[][] A;           // 데이터 저장 2차원 행렬
    static int N;               // 지도 크기
    static int complexNum = 0;    // 단지 수
    static int[] houseNum = new int[25*25]; // 단지에 속하는 집 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        A = new int[N][N];
        visited = new boolean[N][N];

        // 전체 사각형 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(line.substring(j, j+1));
            }
        }

        // 단지 수 구하기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(A[i][j] == 1 && !visited[i][j]){
                    complexNum++;
                    BFS(i,j);
                }
            }
        }

        Arrays.sort(houseNum);
        System.out.println(complexNum);

        for(int i = 0; i < houseNum.length; i++){
            if(houseNum[i] == 0) {}
            else{
                System.out.println(houseNum[i]);
            }
        }
    }

    private static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i,j});
        visited[i][j] = true;
        houseNum[complexNum]++;  // 해당 단지번호의 집 갯수 +1

        while(!queue.isEmpty()) {
            int[] now = queue.poll(); // 현재 자리 체크
            for (int k = 0; k < 4; k++) { // 상하좌우 탐색
                int x = now[0] + dx[k];   // ex) k가 0일 때 dx: 현재 x값 그대로
                int y = now[1] + dy[k];   // ex) k가 0일 때 dy: 현재 y값 + 1  -> down

                // 유효한 좌표인지 검사
                // 배열을 넘어가면 X
                if(x >= 0 && y >= 0 && x < N && y < N) {
                    // 변경된 x, y 가 0이면 X, 방문한 배열이면 안됨
                    if(A[x][y] != 0 && !visited[x][y] ) {
                        visited[x][y] = true;   // 방문 처리
                        queue.add(new int[] {x,y});
                        houseNum[complexNum]++; // 해당 단지번호의 집 갯수 +1
                    }
                }
            }
        }
    }
}
