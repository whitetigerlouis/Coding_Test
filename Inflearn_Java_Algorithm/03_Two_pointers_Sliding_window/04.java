 /*
4. 연속 부분수열
설명
N개의 수로 이루어진 수열이 주어집니다.
이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램을 작성하세요.
만약 N=8, M=6이고 수열이 다음과 같다면
1 2 1 3 1 1 1 2
합이 6이 되는 연속부분수열은 {2, 1, 3}, {1, 3, 1, 1}, {3, 1, 1, 1}로 총 3가지입니다.

입력
첫째 줄에 N(1≤N≤100,000), M(1≤M≤100,000,000)이 주어진다.
수열의 원소값은 1,000을 넘지 않는 자연수이다.

출력
첫째 줄에 경우의 수를 출력한다.

예시 입력 1 
8 6
1 2 1 3 1 1 1 2

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
        m = in.nextInt();
        A = new int[n+1];
        for (int i=0; i<n; i++) {
            A[i] = in.nextInt();
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
        int answer = 0, sum = 0, lt = 0;

        for (int rt=0; rt<n; rt++) {
            sum += A[rt]; // rt를 하나씩 증가하면서 값을 더한다
            if (sum == m)
                answer++;

            while (sum >= m) { // sum이 m보다 크거나 같으면 lt 값을 빼고 하나 증가시킨다
                sum -= A[lt++];
                if (sum == m) // lt값을 뺐을 때 조건을 맞을 경우도 있기에 체크를 해야한다
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
