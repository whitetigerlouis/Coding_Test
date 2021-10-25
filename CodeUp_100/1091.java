import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt(); // 시작 값
        int m = in.nextInt(); // 곱할 값
        int d = in.nextInt(); // 더할 값
        int n = in.nextInt(); // 몇 번째 수
        int sum = a;
        for (int i = 2; i <= n; i++) {
            sum = (sum * -2) + 1;
        }
        System.out.println(sum);
    }
}
