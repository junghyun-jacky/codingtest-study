import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int count = 0;
        int tmp = number;
        do {
            count += 1;
            number = ((number % 10) * 10) + (((number / 10) + (number % 10)) % 10);
            if(tmp == number) {
                break;
            }
        } while(number != tmp);
        System.out.println(count);
    }

}
