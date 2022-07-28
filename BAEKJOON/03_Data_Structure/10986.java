/*
[백준] 10986번: 나머지 합 구하기
*/
import java.io.*;
import java.util.*;

public class Main {
    int N, M;
    long[] S;
    long[] C;
  
    void InputData() throws IOException {
      Scanner in = new Scanner(System.in);
      N = in.nextInt();
      M = in.nextInt();
      S = new long[N+1];
      C = new long[M+1];
      S[0] = in.nextInt();
      for (int i=1; i<N; i++) {
          S[i] = S[i-1] + in.nextInt();
      }
  }


    long solve() {
        long ans = 0;
        // 1. 합배열의 모든 값에 %M 연산 수행하기
        for (int i=0; i<N; i++) {
            int remainder = (int)(S[i]%M);
            if (remainder == 0) ans++;// 2. 처음부터 j까지 합인 경우 카운트하기
            C[remainder]++;
        }

        // 3. 부분합에서 S[j]%M == S[i-1]%M인 경우 카운트하기
        for (int i=0; i<M; i++) {
            if (C[i]>1) {
                ans += C[i] * (C[i]-1)/2;
            }
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
            Main m = new Main();
            m.InputData();//입력

    //여기서부터 작성
    System.out.println(m.solve());
    }
}
