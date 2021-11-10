import java.util.*;
/*
    문제: 1로 만들기
    정수 X가 주어졌을 때, 정수 X에 사용할 수 있는 연산은 다음과 같이 4가지이다
    - X가 5로 나누어 떨어지면, 5로 나눈다
    - X가 3으로 나누어 떨어지면, 3으로 나눈다
    - X가 2로 나누어 떨어지면, 2로 나눈다
    - X에서 1을 뺀다
    정수 X가 주어졌을 때, 연산 4개를 적절히 사용해서 값을 1로 만들고자 한다. 연산을 사용하는 횟수의
    최솟값을 출력하라. 예를 들어 정수가 26이면 다음과 같이 계산해서 3번의 연산이 최솟값이다
    ex) 26 → 25 → 5 → 1
*/
public class Main {
    public static int[] DP = new int[3001]; // 최소 연산회수 저장

    public static void main(String[] args) {
        // 입력받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // DP 진행(bottom up)
        // f(1)은 이미 1이기 때문에 연산회수는 0이다.
        DP[1] = 0;
        System.out.println("[DBG] DP[0] = 0");
        for (int i = 2; i <= N; i++) {
            // (1) 현재 수에서 -1을 빼는 경우
            DP[i] = DP[i - 1] + 1;

            // (2) 현재 수에서 2로 나누는 경우 - (1)의 값과 비교해서 더 작은 값을 선택
            if (i % 2 == 0) {
                DP[i] = Math.min(DP[i], DP[i / 2] + 1);
            }
            // (3) 현재 수에서 3로 나누는 경우 - (1)의 값과 비교해서 더 작은 값을 선택
            if (i % 3 == 0) {
                DP[i] = Math.min(DP[i], DP[i / 3] + 1);
            }
            // (4) 현재 수에서 5로 나누는 경우 - (1)의 값과 비교해서 더 작은 값을 선택
            if (i % 5 == 0) {
                DP[i] = Math.min(DP[i], DP[i / 5] + 1);
            }
            System.out.println("[DBG] DP[" + i + "] = " + DP[i]);
        }
        System.out.println(DP[N]);
    }
}
