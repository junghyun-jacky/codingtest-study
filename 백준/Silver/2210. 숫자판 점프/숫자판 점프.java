import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int[][] map = new int[5][5];;

    static HashSet<String> answer = new HashSet<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // map 입력 받기
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<5; i++) {
            for(int j=0; j<5 ; j++) {
                bfs(i,j);
            }
        }
        System.out.println(answer.size());

    }

    private static void bfs(int x, int y) {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node (x,y, ""));

        while(!queue.isEmpty()) {

            Node now = queue.poll(); // 현재 자리 체크

            if(now.str.length() >= 6 ) {
                answer.add(now.str);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx >= 5 || ny >= 5 || nx < 0 || ny < 0) {
                    continue;
                }
                queue.add(new Node(nx,ny, now.str+String.valueOf(map[nx][ny])));
            }
        }
    }

    public static class Node{
        int x;
        int y;
        String str;

        Node(int x,int y, String str){
            this.x = x;
            this.y = y;
            this.str = str;
        }
    }
}