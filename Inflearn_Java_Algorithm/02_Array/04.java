 /*
    4. 피보나치 수열
    설명
    1) 피보나키 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
    2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.
    
    입력
    첫 줄에 총 항수 N(3<=N<=45)이 입력된다.
    
    출력
    첫 줄에 피보나치 수열을 출력합니다.
    
    예시 입력 1 
    10
    
    예시 출력 1
    1 1 2 3 5 8 13 21 34 55
*/

import java.util.*;

public class Main {
    int n = 0;
    int[] A;
    
    public void inputData() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        //A = new int[n+1];
        //for (int i=0; i<n; i++) {
        //    A[i] = in.nextInt();
        //}
        in.close();
    }

  /*
    1. 가위바위보의 법칙을 찾는다.
    2. A-B를 하면 결과값이 1, 2, 0, -1, -2 밖에 나올 수가 없는데 여기서 상관관계를 찾는다.
    3. 1, -2면 A승, 2, -1이면 B승, 0이면 비김이다.
  */
    public void solve() {
        int ans = 0;
        A = new int[n+1];
        A[0] = 1;
        A[1] = 0 + A[0];
        A[2] = A[0] + A[1];
        for (int i = 2; i < n; i++) {
            A[i] = A[i-2] + A[i-1];
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.inputData();
        m.solve();
        for (int i = 0; i < m.n; i++) {
            System.out.print(m.A[i] + " ");
        }
    }
}
