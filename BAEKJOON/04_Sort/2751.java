/*
[백준] 2751번: 수 정렬하기2
*/

import java.util.*;

public class Main {
    int N;
    int[] A;
    int[] tmp; // 정렬할 때 사용할 임시 배열

	void InputData() {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        A = new int[N+1];
        tmp = new int[N+1];
        for (int i=1; i<=N; i++) {
            A[i] = in.nextInt();
        }
    }

    public void merget_sort(int s, int e) {// s: 시작점, e: 종료점, m: 중간점
        if (e - s < 1)
            return;

        int m = s + (e - s) / 2;

        merget_sort(s, m);
        merget_sort(m+1, e);

        for (int i=s; i<= e; i++) {
            tmp[i] = A[i];
        }

        // 두 그룹을 병합하는 로직
        int k = s;
        int index1 = s; // 앞쪽 그룹 시작점
        int index2 = m + 1; // 뒤쪽 그룹 시작점

        // 양쪽 그룹의 인덱스가 가리키는 값 중 더 작은 수를 선택해 저장하고
        // 선택된 데이터의 index를 오른쪽으로 한칸 이동한다.
        while (index1 <= m && index2 <= e) {
            if (tmp[index1] > tmp[index2]) {
                A[k] = tmp[index2];
                k++;
                index2++;
            } else {
                A[k] = tmp[index1];
                k++;
                index1++;
            }
        }

        // 한쪽 그룹의 정렬이 완료되면 남은 그룹도 정렬한다.
        while (index1 <= m) {
            A[k] = tmp[index1];
            k++;
            index1++;
        }
        while (index2 <= e) {
            A[k] = tmp[index2];
            k++;
            index2++;
        }
    }
    
    void solve() {
        int ans = 0;
        merget_sort(1, N);
        //System.out.println(A[K-1]);
        for (int x=1; x<=N; x++) 
            System.out.println(x);
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
