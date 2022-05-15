 /*
3. 최대 매출
설명
현수의 아빠는 제과점을 운영합니다. 현수 아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다.
만약 N=10이고 10일 간의 매출기록이 아래와 같습니다. 이때 K=3이면
12 1511 20 2510 20 19 13 15
연속된 3일간의 최대 매출액은 11+20+25=56만원입니다.
여러분이 현수를 도와주세요.

입력
첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.

출력
첫 줄에 최대 매출액을 출력합니다.

예시 입력 1 
10 3
12 15 11 20 25 10 20 19 13 15

예시 출력 1
56
*/

import java.util.*;

public class Main {
    int n, k;
    int[] A;
    
    public void inputData() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        k = in.nextInt();
        A = new int[n+1];
        for (int i=0; i<n; i++) {
            A[i] = in.nextInt();
            //System.out.print(A[i] + " ");
        }
        in.close();
    }

  /*
    1. 최대 매출액 변수를 정해서 계속 업데이트 하자
    2. 입력범위가 100,000이면 이중루프를 돌리면 time out이 난다. 루프 1개로 끝내자.
    3. sliding window 문제이므로 초기값을 먼저 계산하자.
  */
    public int solve() {
        int answer = 0, sum = 0;
        // 초기 윈도우값 계산
        for (int i=0; i<k; i++)
            sum += A[i];
        answer = sum;

        // 윈도우를 옆으로 밀면서 한칸 더하고, 한칸 빼자
        for (int i=k; i<n; i++) {
            sum += A[i] - A[i-k];
            answer = Math.max(answer, sum); // 더 큰수를 저장
        }
        return answer;
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.inputData();
        //for (int x : m.solve()) {
        //    System.out.print(x + " ");
        //}
        System.out.println(m.solve());
    }
}
