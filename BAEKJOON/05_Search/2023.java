/*
[백준] 2023번: 신기한 소수
*/

import java.util.*;

public class Main {
    int N;

	void InputData() {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
    }

    void DFS(int number, int jarisu) {
        // 1. 자릿수가 N이고, 소수이면 출력
        if (jarisu == N) {
            if (isPrime(number)) {
                System.out.println(number);
            }
            return; // 종료 조건
        }

        for (int i=1; i<10; i++) {
            if (i%2 == 0) continue;//짝수이면 아래구문 수행할 필요 없음

            // 한자리 늘렸을 때 여전히 소수라면 DFS 탐색 시작
            if (isPrime(number*10 + i)) {
                DFS(number*10+i, jarisu+1);
            }
        }
    }

    boolean isPrime(int num) {
        // 1과 자기 자신을 제외한 다른 수로 나눠지면 소수가 아니다.
        for (int i=2; i<=num/2; i++) {
            if (num%i == 0)
                return false;
        }
        return true;
    }
    
    void solve() {
        for (int i=2; i<=9; i++) {
            if (isPrime(i))
                DFS(i, 1);
        }

    }

	public static void main(String[] args) {
		Main m = new Main();
		m.InputData();//입력
		//여기서부터 작성
        m.solve();
        //System.out.println(m.solve());
        //for (int x : m.solve()) {
        //    System.out.print(x+" ");
        //}
	}
}
