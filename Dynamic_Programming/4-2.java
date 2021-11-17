import java.util.*;

/*
    다이나믹 프로그래밍 완전정복
    4-2. 재귀로 풀기
*/
public class Main {
    static int minPathCost(int cost[][], int m, int n) {
        // 재귀호출 종료조건(최소단위)
        if (m == 0 && n == 0) 
            return cost[0][0];
        if (m == 0) 
            return minPathCost(cost, 0, n - 1) + cost[0][n];
        if (n == 0) 
            return minPathCost(cost, m - 1, 0) + cost[m][0];

        int x = minPathCost(cost, m - 1, n);
        int y = minPathCost(cost, m, n - 1);

        return Math.min(x, y) + cost[m][n];
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
        
        // 재귀함수 알고리즘 시작
        int sum = minPathCost(Cost, M - 1, N - 1);
        System.out.print(sum);

    }
}
