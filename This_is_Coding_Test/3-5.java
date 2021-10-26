import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 1. 입력
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // 자연수 N
        int k = in.nextInt(); // N을 나누는 수 K

        // 2. 먼저 K로 나눠지는 지 확인
        int cnt = 0;
        while(true) {
            if (n / k == 1 && n % k == 0) {
                cnt++;
                break;
            }

            if (n % k != 0) {
                n -= 1;
                cnt++;
                System.out.println("(1) N = " + n);
            } else {
                n /= k;
                cnt++;
                System.out.println("(2) N = " + n);
            }
        }
        // 4. 답 출력
        System.out.println(cnt);
    }
}
