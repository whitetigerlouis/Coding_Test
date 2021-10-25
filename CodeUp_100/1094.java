import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // 출석을 부른 횟수
        int A[] = new int[23+1];
        for (int i = 0; i < n; i++) {
            A[i] = in.nextInt();
        }

        for (int i = n-1; i >= 0; i--) 
            System.out.print(A[i] + " ");
    }
}
