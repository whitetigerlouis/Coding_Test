import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt(); // 시작값
        int d = in.nextInt(); // 등차의 값
        int n = in.nextInt(); // 몇 번째 수
        int sum = a;
        for (int i = 2; i <= n; i++) {
            sum += d;
        }
        System.out.println(sum);
    }
}
