import java.util.*;

/*
    다이나믹 프로그래밍 완전정복
    4-3. Memoziation(top-down방식)
    ex) 3 4
    1 3 5 8
    4 2 1 7
    4 3 2 3
*/
public class Main {
    static int MEM[][];
    static int minPathCost(int cost[][], int m, int n) {
        // 이미 계산된 값이면 메모에서 불러옴
        if (MEM[m][n] != 0)
            return MEM[m][n];
        
        // 종료조건(최소단위)
        if (m == 0 && n == 0) {
            //return cost[0][0];
            MEM[m][n] = cost[0][0];  
        } else if (m == 0) {
            //return minPathCost(cost, 0, n - 1) + cost[0][n];
            MEM[m][n] = minPathCost(cost, 0, n - 1) + cost[0][n];
        } else if (n == 0) {
            //return minPathCost(cost, m - 1, 0) + cost[m][0];
            MEM[m][n] = minPathCost(cost, m - 1, 0) + cost[m][0];
        } else {
            int x = minPathCost(cost, m - 1, n);
            int y = minPathCost(cost, m, n - 1);

            //return Math.min(x, y) + cost[m][n];
            MEM[m][n] = Math.min(x, y) + cost[m][n];
        }
        return MEM[m][n];
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
        MEM = new int[M + 1][N + 1]; // 0으로 초기화
        
        // 재귀함수 알고리즘 시작
        int sum = minPathCost(Cost, M - 1, N - 1);
        System.out.print(sum);

    }
}
