import java.util.*;

/*
    다이나믹 프로그래밍 완전정복
    4-3. DP(bottom-up방식)
    ex) 3 4
    1 3 5 8
    4 2 1 7
    4 3 2 3
*/
public class Main {
    static int DP[][]; // DP용 누적값 저장 테이블
    static int minPathCost(int cost[][], int m, int n) {
        DP[0][0] = cost[0][0]; // 출발점 저장

        // 제일 위 행
        for (int j = 1; j < n; j++) {
            DP[0][j] = DP[0][j - 1] + cost[0][j];
        }

        // 제일 왼쪽 열
        for (int i = 1; i < m; i++) {
            DP[i][0] = DP[i - 1][0] + cost[i][0];
        }

        // 나머지 칸 채우기
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                DP[i][j] = Math.min(DP[i - 1][j], DP[i][j - 1]) + cost[i][j];
            }
        }
        return DP[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력값 받기
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[][] Cost = new int[M + 1][N + 1];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                Cost[i][j] = sc.nextInt();
            }
        }
        DP = new int[M + 1][N + 1]; // 0으로 초기화
        
        // 재귀함수 알고리즘 시작
        int sum = minPathCost(Cost, M, N);
        System.out.print(sum);

    }
}
