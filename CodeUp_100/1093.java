import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // 출석을 부른 횟수
        int A[] = new int[23+1];
        for (int i = 1; i <= n; i++) {
            int idx = in.nextInt();
            A[idx] += 1;
        }

        for (int i = 1; i <= 23; i++) 
            System.out.print(A[i] + " ");
    }
}
