import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 1. 입력
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // 배열의 크기 N
        int m = in.nextInt(); // 숫자가 더해지는 횟수 M
        int k = in.nextInt(); // 연속덧셈 가능한 수 K
        int[] A = new int[n + 1];
        for (int i = 0; i < n; i++) {
            A[i] = in.nextInt();
        }

        // 2. 내림차순으로 정렬
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (A[i] < A[j]) {
                    int tmp = A[i];
                    A[i] = A[j];
                    A[j] = tmp;
                }
            }
        }

        // 3. 가장 큰 수 구하기
        int sum = 0, first = A[0], second = A[1];
        while(true) {
            // 첫번째 큰 수 계산
            for (int i = 0; i < k; i++) {
                if (m == 0) break;
                sum += first;
                m--;
            }
            // 두번째 큰 수 계산
            if (m == 0) break;
            sum += second;
            m--;
        }

        // 4. 답 출력
        System.out.println(sum);
    }
}
