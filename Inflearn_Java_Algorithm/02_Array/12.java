 /*
12. 멘토링
설명
현수네 반 선생님은 반 학생들의 수학점수를 향상시키기 위해 멘토링 시스템을 만들려고 합니다.
멘토링은 멘토(도와주는 학생)와 멘티(도움을 받는 학생)가 한 짝이 되어 멘토가 멘티의 수학공부를 도와주는 것입니다.
선생님은 M번의 수학테스트 등수를 가지고 멘토와 멘티를 정합니다.
만약 A학생이 멘토이고, B학생이 멘티가 되는 짝이 되었다면, A학생은 M번의 수학테스트에서 모두 B학생보다 등수가 앞서야 합니다.
M번의 수학성적이 주어지면 멘토와 멘티가 되는 짝을 만들 수 있는 경우가 총 몇 가지 인지 출력하는 프로그램을 작성하세요.

입력
첫 번째 줄에 반 학생 수 N(1<=N<=20)과 M(1<=M<=10)이 주어진다.
두 번째 줄부터 M개의 줄에 걸쳐 수학테스트 결과가 학생번호로 주어진다. 학생번호가 제일 앞에서부터 1등, 2등, ...N등 순으로 표현된다.
만약 한 줄에 N=4이고, 테스트 결과가 3 4 1 2로 입력되었다면 3번 학생이 1등, 4번 학생이 2등, 1번 학생이 3등, 2번 학생이 4등을 의미합니다.

출력
첫 번째 줄에 짝을 만들 수 있는 총 경우를 출력합니다.

예시 입력 1 
4 3
3 4 1 2
4 3 2 1
3 1 4 2

예시 출력 1
3
*/

import java.util.*;

public class Main {
    int n, m;
    int[][] A;
    
    public void inputData() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        A = new int[m+1][n+1];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                A[i][j] = in.nextInt();
            }
        }
        in.close();
    }

  /*
    1. 멘토학생 i의 등수와 멘티학생 j의 등수를 모든 테스트에서 찾는다
    2. i의 등수가 j의 등수보다 앞서는 경우만 저장한다.
    3. 그 수가 총 테스트 수와 같으면 모든 테스트에서 성적이 좋은 것이므로 멘토가 될 수 있다.
  */
    public int solve() {
        int answer = 0;
        for (int i = 1; i <= n; i++) { //멘토학생번호 i
            for (int j = 1; j <= n; j++) { // 멘티학생번호 j
                int count = 0;
                for (int k=0; k<m; k++) { // 테스트 번호
                    int pi=0, pj=0; // 등수
                    for (int s=0; s<n; s++) { // 등수 검색
                        if (A[k][s]==i) pi = s; // i학생의 등수를 저장
                        if (A[k][s]==j) pj = s; // j학생의 등수를 저장
                    }
                    if (pi<pj) count++; // i의 등수가 j의 등수보다 앞서면 count++
                }
                if (count == m) { // 모든 테스트에서 i의 등수가 j의 등수보다 앞서면 OK
                    answer++;
                }
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
