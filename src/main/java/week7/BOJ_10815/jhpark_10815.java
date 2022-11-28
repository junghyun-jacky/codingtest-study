package main.java.week7.BOJ_10815;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class jhpark_10815 {
    static int N;
    static int [] arrN;
    static int M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arrN = new int [N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arrN[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());


        Arrays.sort(arrN);

        for(int i=0; i<M; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(BinarySearch(num)) {
                System.out.print("1 ");
            } else {
                System.out.print("0 ");
            }

        }
    }

    static boolean BinarySearch(int num) {
        int leftIndex = 0;
        int rightIndex = N - 1;

        while(leftIndex <= rightIndex) {
            int midIndex = (leftIndex + rightIndex) / 2;
            int mid = arrN[midIndex];

            if(num == mid) {
                return true;
            }
            else if(num > mid) {
                leftIndex = midIndex + 1;
            }
            else {
                rightIndex = midIndex - 1;
            }
        }
        return false;
    }
}