/*
[백준] 2018번: 수들의 합 5
*/
import java.io.*;
import java.util.*;

public class Main {
    int N;
    int[] A;

	void InputData() throws IOException{
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        A = new int[N+1];
        for (int i=1; i<=N; i++) 
            A[i] = i;
	}

    int solve() {
        int ans = 1, start_idx = 1, end_idx = 1, sum = 1; // 초기화
        // 본인 자신만 있을 때도 카운트 되기 때문에 1로 초기화 한다.

        while (end_idx < N) {
            if (sum==N) {
                ans++;
                end_idx++; // 뒷자리 수 하나를 더해본다.
							sum += end_idx;
            } else if (sum < N) {
                end_idx++;
                sum += end_idx;
            } else if (sum > N) {
                sum -= start_idx; // 앞자리 수 하나를 빼본다.
                start_idx++;
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
