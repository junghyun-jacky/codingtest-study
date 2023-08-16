import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    // 학생이 앉을 map
    static int[][] map;

    // 학생별 선호 학생들
    static Map<Integer, Set<Integer>> likeStudent;
    static int[] students;
    
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    // N, 만족도 합
    static int N, sum;

    public static void main(String[] args) throws IOException {
        init();

        solution();

        answer();
    }

    private static void solution() {
        // 1. 좌석 배치
        for (int i = 0; i < students.length; i++) {
            Point point = findPoint(students[i]);
            map[point.x][point.y] = students[i];
        }

        // 2. 선호도 합산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int count = getLikeCount(i, j, map[i][j]);
                if (count > 0) {
                    sum += (int) Math.pow(10, count - 1);
                }
            }
        }

    }

    // 앉을 좌석 찾기
    private static Point findPoint(int student) {
        Point point = null;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 이미 자리에 누가 있으면 continue
                if(map[i][j] > 0) {
                    continue;
                }

                // 현재 자리의 정보 (x, y, 인접 선호 학생 수, 빈칸 수)
                Point now = new Point(i, j, getLikeCount(i, j, student), getEmptyCount(i, j));

                // 비교할 point가 null이면 초기화 후 continue
                if (point == null) {
                    point = now;
                    continue;
                }

                // 이전 좌석과 현재 좌석 비교
                if(point.compareTo(now) > 0) {
                    point = now;
                }
            }
        }
        return point;
    }

    // 인접 선호 학생 수
    private static int getLikeCount(int x, int y, int student) {
        int count = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                continue;
            }

            // 인접한 학생이 좋아하는 학생에 포함되면 count 증가
            if(likeStudent.get(student).contains(map[nx][ny])) {
                count++;
            }
        }

        return count;
    }

    // 빈 자리 개수
    private static int getEmptyCount(int x, int y) {
        int count = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                continue;
            }

            // 비었으면 count 증가
            if(map[nx][ny] == 0) {
                count++;
            }
        }

        return count;
    }

    private static void answer() {
        System.out.println(sum);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        sum = 0;
        map = new int[N][N];
        students = new int[N * N];
        likeStudent = new HashMap<>();

        for (int i = 0; i < N * N; i++) {
            st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            students[i] = student;

            likeStudent.put(student, new HashSet<>());
            for (int j = 0; j < 4; j++) {
                likeStudent.get(student).add(Integer.parseInt(st.nextToken()));
            }
        }
    }

    static class Point implements Comparable<Point> {
        int x, y, likeCount, emptyCount;

        public Point(int x, int y, int likeCount, int emptyCount) {
            this.x = x;
            this.y = y;
            this.likeCount = likeCount;
            this.emptyCount = emptyCount;
        }

        @Override
        public int compareTo(Point o) {
            if(this.likeCount != o.likeCount) {
                return -(this.likeCount - o.likeCount);
            }

            if(this.emptyCount != o.emptyCount) {
                return -(this.emptyCount - o.emptyCount);
            }

            if(this.x != o.x) {
                return this.x - o.x;
            }

            return this.y - o.y;
        }
    }

}