import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static boolean[] check;
    static int cycle;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int i=0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n+1];
            cycle = 0;

            st = new StringTokenizer(br.readLine());
            for(int j=1; j<n+1; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            check = new boolean[n+1];
            for(int k=1; k < n+1; k++) {
                if(!check[k]) {
                    dfs(k);
                    cycle++;
                }
            }
            System.out.println(cycle);
        }

    }

    static void dfs(int i) {
        check[i] = true;
        int next = arr[i];
        if(!check[next]) {
            dfs(arr[i]);
        }
    }

}
