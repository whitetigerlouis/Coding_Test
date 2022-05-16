 /*
6. 최대 길이 연속부분수열
설명
0과 1로 구성된 길이가 N인 수열이 주어집니다. 여러분은 이 수열에서 최대 k번을 0을 1로 변경할 수 있습니다. 여러분이 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.
만약 길이가 길이가 14인 다음과 같은 수열이 주어지고 k=2라면
1 1 0 0 1 1 0 1 1 0 1 1 0 1

여러분이 만들 수 있는 1이 연속된 연속부분수열은
이며 그 길이는 8입니다.

입력
첫 번째 줄에 수열의 길이인 자연수 N(5<=N<100,000)이 주어집니다.
두 번째 줄에 N길이의 0과 1로 구성된 수열이 주어집니다.

출력
첫 줄에 최대 길이를 출력하세요.

예시 입력 1 
14 2
1 1 0 0 1 1 0 1 1 0 1 1 0 1

예시 출력 1
8
*/

import java.util.*;

public class Main {
    int n, k;
    int[] A;
    
    public void inputData() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        k = in.nextInt();
        A = new int[n];
        for (int i=0; i<n; i++) {
            A[i] = in.nextInt();
            //System.out.print(A[i] + " ");
        }
        in.close();
    }

  /*
    1. 최대 매출액 변수를 정해서 계속 업데이트 하자
    2. 입력범위가 100,000,000이면 이중루프를 돌리면 time out이 난다.
    3. two pointer 문제
  */
    public int solve() {
        int answer = 0, cnt = 0;// 0->1로 변경한 값의 횟수
        int lt = 1;

        for (int rt=0; rt<n; rt++) { // rt를 증가시킨다
            if (A[rt] == 0) // 0을 만나면 cnt를 증가시킨다. (0->1)
                cnt++;

            while (cnt > k) { // 0->1 변경횟수가 k를 초과하면 반복문 실행
                if (A[lt] == 0) // lt를 증가하면서 0을 찾는다.
                    cnt--; // 1->0으로 원복시킨다는 의미
                lt++; // lt를 증가하면서 계속 찾는다
            }
            answer = Math.max(answer, rt-lt+1); //rt와 lt 사이의 거리를 잰다

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
