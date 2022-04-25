 /*
    3. 가위 바위 보
    설명
    A, B 두 사람이 가위바위보 게임을 합니다. 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다. 비길 경우에는 D를 출력합니다.
    가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.
    
    예를 들어 N=5이면
    두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지 출력하는 프로그램을 작성하세요.
    
    
    입력
    첫 번째 줄에 게임 횟수인 자연수 N(1<=N<=100)이 주어집니다.
    두 번째 줄에는 A가 낸 가위, 바위, 보 정보가 N개 주어집니다.
    세 번째 줄에는 B가 낸 가위, 바위, 보 정보가 N개 주어집니다.
    
    
    출력
    선생님이 볼 수 있는 최대학생수를 출력한다.
    
    예시 입력 1 
    5
    2 3 3 1 3
    1 1 2 2 3
    
    예시 출력 1
    A
    B
    A
    B
    D
*/

import java.util.*;

public class Main {
    int n = 0;
    int[] A;
    int[] B;
    //char[] Win;
    
    public void inputData() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        A = new int[n+1];
        B = new int[n+1];
        for (int i=0; i<n; i++) {
            A[i] = in.nextInt();
        }
        for (int i=0; i<n; i++) {
            B[i] = in.nextInt();
        }
        in.close();
    }

  /*
    1. 가위바위보의 법칙을 찾는다.
    2. A-B를 하면 결과값이 1, 2, 0, -1, -2 밖에 나올 수가 없는데 여기서 상관관계를 찾는다.
    3. 1, -2면 A승, 2, -1이면 B승, 0이면 비김이다.
  */
    public void solve() {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = A[i] - B[i];
            if (ans == 0) {
                System.out.println("D");
            } else if (ans == 1 || ans == -2) {
                System.out.println("A");
            } else if (ans == 2 || ans == -1) {
                System.out.println("B");
            }
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.inputData();
        m.solve();
    }
}
