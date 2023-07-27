import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<int[]>[] list;

    // 지름길의 개수(N), 고속도로 길이(D)
    public static int N, D;

    // 최단 거리 테이블
    public static int[] d = new int[10001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        list = new ArrayList[10001];
        for(int i=0; i<list.length; i++) {
            list[i]=new ArrayList<>();
        }

        // a번 노드에서 b번 노드로 가는 비용이 c라는 의미
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            list[a].add(new int[] {b, c});
        }

        // init int[] d
        for(int i=0; i<d.length; i++) {
            d[i]=i;
        }

        // dijkstra
        for(int i = 0; i <= D; i++) {
            if(i != 0)
                d[i] = Math.min(d[i-1]+1, d[i]) ;
            if(list[i].size() > 0) {
                for(int[] tmp : list[i]) {
                    int val = tmp[1];
                    int end = tmp[0];
                    if(d[end] > d[i]+val) {
                        d[end] = d[i]+val;
                    }
                }
            }

        }

        System.out.println(d[D]);
    }
}