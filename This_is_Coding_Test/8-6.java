import java.util.*;

/*
    DP 실전문제
    점화식
*/
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력값 받기
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = sc.nextInt();

        // DP 테이블 생성
        int[] DP = new int[N];
        
        // DP 알고리즘 시작
        // A[i]의 창고를 털지 말지를 결정하는 기준은 DP[i-1] vs DP[i-2] + A[i]이다.
        // 바로 옆의 창고는 털지 못하기 때문
        DP[0] = A[0];
        DP[1] = Math.max(DP[0], A[1]);
        System.out.println("[DBG] DP[0] = " + DP[0]);
        System.out.println("[DBG] DP[1] = " + DP[1]);
        for (int i = 2; i < N; i++) {
            DP[i] = Math.max(DP[i-2] + A[i], DP[i-1]);
            System.out.println("[DBG] DP[" + i + "] = " + DP[i]);
        }

        System.out.println(DP[N-1]);
    }
}
