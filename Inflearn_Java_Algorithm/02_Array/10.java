 /*
10. 봉우리
설명
지도 정보가 N*N 격자판에 주어집니다. 각 격자에는 그 지역의 높이가 쓰여있습니다.
각 격자판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다. 봉우리 지역이 몇 개 있는 지 알아내는 프로그램을 작성하세요.
격자의 가장자리는 0으로 초기화 되었다고 가정한다.
만약 N=5 이고, 격자판의 숫자가 다음과 같다면 봉우리의 개수는 10개입니다.

입력
첫 줄에 자연수 N이 주어진다.(2<=N<=50)
두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.

출력
봉우리의 개수를 출력하세요.

예시 입력 1 
5
5 3 7 2 3
3 7 1 6 1
7 2 5 3 4
4 3 6 4 1
8 7 3 5 2

예시 출력 1
10
*/

import java.util.*;

public class Main {
    int n = 0;
    int[][] A;
    
    public void inputData() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        A = new int[n+10][n+10];
        // 격자의 가장자리를 0으로 채우기 위해서 A[1][1]부터 값을 넣는다.
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                A[i][j] = in.nextInt();
            }
        }
        in.close();
    }

  /*
    1. 
  */
    // 시계방향 북 - 동 - 남 - 서
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    public int solve() {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                //System.out.println("A[i][j] = " + A[i][j]);
                boolean flag = true;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    //System.out.println("A[nx][ny] = " + A[nx][ny]);
                    if (A[nx][ny] >= A[i][j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    count++;
                    //System.out.println("count = " + count);
                }
            }
        }
        return count;
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
