import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int[][] map;
    static int N, M;
    static ArrayList<Point> person;
    static ArrayList<Point> chicken;
    static boolean[] open;
    static int cityChickenDistance;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        person = new ArrayList<>();
        chicken = new ArrayList<>();

        // 집과 치킨집에 해당하는 좌표를 ArrayList에 넣는다
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 1) {
                    person.add(new Point(i, j));
                } else if (map[i][j] == 2) {
                    chicken.add(new Point(i, j));
                }
            }
        }

        cityChickenDistance = Integer.MAX_VALUE;
        open = new boolean[chicken.size()];

        DFS(0, 0);
        System.out.println(cityChickenDistance);
    }

    public static void DFS(int start, int count) {
        // 치킨집이 open한 개수 == M 일 경우, 모든 집에 대하여 M개의 치킨집 중 최단거리를 계산
        if (count == M) {
            int answer = 0;

            for (int i = 0; i < person.size(); i++) {
                int temp = Integer.MAX_VALUE;

                // 어떤 집과 치킨집 중 open한 치킨집의 모든 거리를 비교
                // 그 중, 최소 거리를 구한다
                for (int j = 0; j < chicken.size(); j++) {
                    if (open[j]) {
                        // 임의의 두 칸 (r1, c1)과 (r2, c2) 사이의 거리는 |r1-r2| + |c1-c2|
                        int distance = Math.abs(person.get(i).x - chicken.get(j).x)
                                + Math.abs(person.get(i).y - chicken.get(j).y);
                        temp = Math.min(temp, distance);
                    }
                }
                answer += temp;
            }
            cityChickenDistance = Math.min(cityChickenDistance, answer);
            return;
        }

        // 백트래킹
        for (int i = start; i < chicken.size(); i++) {
            open[i] = true;
            DFS(i + 1, count + 1);
            open[i] = false;
        }
    }

}
