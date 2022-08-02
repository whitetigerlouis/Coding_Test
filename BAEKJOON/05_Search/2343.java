/*
[백준] 2343번: 블루레이 만들기
*/

import java.util.*;

public class Main {
    int N, M;
    int[] A;

	void InputData() {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();
        A = new int[N];
        for (int i=0; i<N; i++)
            A[i] = in.nextInt();
    }

    
    void solve() {
        // start, end 값 정하기
        int start = 0, end = 0;
        for (int i=0; i<N; i++) {
            if (start < A[i]) // start는 가장 긴 레슨시간
                start = A[i];
            end = end + A[i]; // end는 모든 레슨시간의 합
        }

        // 블루레이 디스크의 시간은 mid로 한다.
        while (start <= end) {
            int mid = (start + end)/2;
            int sum=0, count=0;

            // mid값으로 모든 레슨을 저장할 수 있는지 확인
            for (int i=0; i<N; i++) {
                if (sum + A[i] > mid) { // 디스크 갯수 추가
                    count++;
                    sum = 0;
                }
                sum = sum + A[i];
            }

            if (sum != 0) // 탐색 후에 sum=0이 아니면 추가 디스크 필요함.
                count++;

            if (count > M) {// 용량이 작다는 거니까 디스크 시간을 늘린다
                start = mid + 1;
            } else { // 용량이 크다는 거니까 디스크 시간을 줄인다.
                end = mid - 1;
            }
        }
        // while문을 종료하면 start+1 or start가 된다.
        System.out.println(start);
    }

	public static void main(String[] args) {
		Main m = new Main();
		m.InputData();
        
		//여기서부터 작성
        m.solve();
        
        //System.out.println(m.solve());
	}
}
