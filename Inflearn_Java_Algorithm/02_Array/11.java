 /*
11. 임시반장 정하기
설명
김갑동 선생님은 올해 6학년 1반 담임을 맡게 되었다.
김갑동 선생님은 우선 임시로 반장을 정하고 학생들이 서로 친숙해진 후에 정식으로 선거를 통해 반장을 선출하려고 한다.

그는 자기반 학생 중에서 1학년부터 5학년까지 지내오면서 한번이라도 같은 반이었던 사람이 가장 많은 학생을 임시 반장으로 정하려 한다.
그래서 김갑동 선생님은 각 학생들이 1학년부터 5학년까지 몇 반에 속했었는지를 나타내는 표를 만들었다.
예를 들어 학생 수가 5명일 때의 표를 살펴보자.

위 경우에 4번 학생을 보면 3번 학생과 2학년 때 같은 반이었고, 3번 학생 및 5번 학생과 3학년 때 같은 반이었으며,
2번 학생과는 4학년 때 같은 반이었음을 알 수 있다. 그러므로 이 학급에서 4번 학생과 한번이라도
같은 반이었던 사람은 2번 학생, 3번 학생과 5번 학생으로 모두 3명이다.
이 예에서 4번 학생이 전체 학생 중에서 같은 반이었던 학생 수가 제일 많으므로 임시 반장이 된다.
각 학생들이 1학년부터 5학년까지 속했던 반이 주어질 때, 임시 반장을 정하는 프로그램을 작성하시오.

입력
첫째 줄에는 반의 학생 수를 나타내는 정수가 주어진다. 학생 수는 3 이상 1000 이하이다.
둘째 줄부터는 1번 학생부터 차례대로 각 줄마다 1학년부터 5학년까지 몇 반에 속했었는지를 나타내는 5개의 정수가 빈칸 하나를 사이에 두고 주어진다.
주어지는 정수는 모두 1 이상 9 이하의 정수이다.

출력
첫 줄에 임시 반장으로 정해진 학생의 번호를 출력한다.
단, 임시 반장이 될 수 있는 학생이 여러 명인 경우에는 그 중 가장 작은 번호만 출력한다.

예시 입력 1 
5
2 3 1 7 3
4 1 9 6 8
5 5 2 4 4
6 5 2 6 7
8 4 2 2 2

예시 출력 1
4
*/

import java.util.*;

public class Main {
    int n = 0;
    int[][] A;
    
    public void inputData() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        A = new int[n+1][6];
        // 배열은 1번지부터 사용한다.
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=5; j++) {
                A[i][j] = in.nextInt();
            }
        }
        in.close();
    }

  /*
    1. 문제와 동일하게 배열도 1번지부터 사용한다. 
    2. for i (1~n)학생과 for j (1~n)학생이 같은 반을 한 적이 있는지 for k (1~5) 번 비교한다.
    3. A[i][k] == A[j][k] 이면 count++하고 break를 한다. 왜냐하면 총학년동안 1번만 같은반이면 되기 때문이다. 여러학년에 걸쳐 같은반을 여러번 한것은 반장 조건에 해당하지 않는다.
    4. 반장의 조건은 여러 학생과 최대한 여러번 같은반을 많이한 학생을 뽑는 것이다.
  */
    public int solve() {
        int max = Integer.MIN_VALUE; // 최소값으로 초기화
        int answer = 0;
        for (int i = 1; i <= n; i++) { //학생[i]와
            int count = 0;
            for (int j = 1; j <= n; j++) { // 학생[j]가
                for (int k=1; k<=5; k++) { // 1~5학년 동안 비교해서
                    //System.out.println("  A[k][j] = "+ A[k][j]);
                    if (A[i][k] == A[j][k]) { // 같은 반을 한적이 있다면
                        count++;
                        //System.out.println("  count = " + count);
                        break; // 다른 학년을 비교할 필요가 없기 때문에 loop 종료
                    }
                }
            }
            //System.out.println("["+i+"] count = " + count);
            //System.out.println("-----------------");
            if (max < count) {
                max = count;
                answer = i;
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
