import java.util.Scanner;

public class jhpark_1065 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int cnt = 0;

        if(X >= 1 &&  X < 100) {
            cnt = X;
        }
        else {
            cnt = 99;
            for(int i=100; i<X+1; i++) {
                if((i%10) - ((i/10)%10) == ((i/10)%10) - (i/100)) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}