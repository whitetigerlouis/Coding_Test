/*
[백준] 1940번: 주몽
*/
import java.io.*;
import java.util.*;

public class Main {
    int N, M;
    int[] A;

	void InputData() throws IOException{
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();
        A = new int[N];
        for (int i=0; i<N; i++) {
            A[i] = in.nextInt();
        }
	}

    int solve() {
        int ans = 0; // 갑옷 갯수를 카운트해서 저장
        int s=0, e=N-1, sum=0; // 초기화 - 시작위치 설정

        // 오름차순 정렬
        Arrays.sort(A);
        //for (int x : A) System.out.print(x+" ");

        while (s < e) {
            sum = A[s]+A[e];
            //System.out.println("sum = "+sum);
            if (sum == M) {
                ans++;
                s++;
                e--;
            } else if (sum < M) {
                s++;
            } else if (sum > M) {
                e--;
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
