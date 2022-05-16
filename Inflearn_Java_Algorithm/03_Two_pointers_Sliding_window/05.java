 /*
5. 연속된 자연수의 합
설명
N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.
만약 N=15이면
7+8=15
4+5+6=15
1+2+3+4+5=15
와 같이 총 3가지의 경우가 존재한다.

입력
첫 번째 줄에 양의 정수 N(7<=N<1000)이 주어집니다.

출력
첫 줄에 총 경우수를 출력합니다.

예시 입력 1 
15

예시 출력 1
3
*/

import java.util.*;

public class Main {
    int n, m;
    int[] A;
    
    public void inputData() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        //m = in.nextInt();
        A = new int[n+1];
        for (int i=1; i<n; i++) {
            //A[i] = in.nextInt();
            A[i] = i;
            //System.out.print(A[i] + " ");
        }
        in.close();
    }

  /*
    1. 최대 매출액 변수를 정해서 계속 업데이트 하자
    2. 입력범위가 100,000,000이면 이중루프를 돌리면 time out이 난다.
    3. sliding window 문제이므로 초기값을 먼저 계산하자.
  */
    public int solve() {
        int answer = 0, sum = 0, lt = 1;

        for (int rt=1; rt<n; rt++) {
            sum += A[rt]; // rt를 하나씩 증가하면서 값을 더한다
            if (sum == n)
                answer++;

            while (sum >= n) { // sum이 m보다 크거나 같으면 lt 값을 빼고 하나 증가시킨다
                sum -= A[lt++];
                if (sum == n) // lt값을 뺐을 때 조건을 맞을 경우도 있기에 체크를 해야한다
                    answer++;
            }
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
