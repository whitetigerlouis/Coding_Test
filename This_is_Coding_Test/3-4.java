import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 1. 입력
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // 배열의 크기 행 N
        int m = in.nextInt(); // 배열의 크기 열 M
        int[][] A = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                A[i][j] = in.nextInt();
            }
        }

        // 2. 각 행을 오름차순으로 정렬
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < m-1; i++) {
                for (int j = i+1; j < m; j++) {
                    if (A[k][i] > A[k][j]) {
                        int tmp = A[k][i];
                        A[k][i] = A[k][j];
                        A[k][j] = tmp;
                    }
                }
            }
        }

        // 3. 각 행의 첫번째 값끼리 비교해서 제일 큰 수를 출력한다.
        int max = A[0][0];
        for (int i = 1; i < n; i++) {
            if (max < A[i][0]) 
                max = A[i][0];
        }
        // 4. 답 출력
        System.out.println(max);
    }
}
