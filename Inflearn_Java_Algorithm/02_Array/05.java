 /*
    5. 소수(에라토스테네스 체)
    설명
    자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
    만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.
    
    입력
    첫 줄에 자연수의 개수 N(2<=N<=200,000)이 주어집니다.
    
    출력
    첫 줄에 소수의 개수를 출력합니다.
    
    예시 입력 1 
    20
    
    예시 출력 1
    8
*/

import java.util.*;

public class Main {
    int n = 0;
    int[] A;
    
    public void inputData() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        A = new int[n+1];
        in.close();
    }

  /*
    1. 처음부터 소수이면 배수는 0->1로 바꾼다.
    2. 0일 때만 카운트++ 한다
  */
    public int solve() {
        int ans = 0;        
        for (int i = 2; i <= n; i++) {
            if (A[i] == 1) continue;
            if (A[i] == 0) {
                ans++;
                int j = i;
                while (j <= n) {
                    A[j] = 1;
                    j = j + i;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.inputData();
        System.out.println(m.solve());
    }
}
