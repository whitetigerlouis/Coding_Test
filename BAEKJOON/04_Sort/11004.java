/*
[백준] 11004번: K번째 수
*/

import java.util.*;

public class Main {
    int N, K;
    int[] A;

	void InputData() {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        K = in.nextInt();
        A = new int[N];
        for (int i=0; i<N; i++) {
            A[i] = in.nextInt();
        }
    }

    public void quickSort(int S, int E) {
        if (S < E) {
            int pivot = partition(S, E);
            if (pivot == K)
                return;
            else if (K < pivot) {
                quickSort(S, pivot-1);
            } else {
                quickSort(pivot+1, E);
            }
        }
    }

    public int partition(int S, int E) {
        int M = (S+E)/2; // 중앙값을 구한다
        swap(S, M); // 중앙값을 첫번째 값과 교체한다.

        int pivot = A[S]; // 교체한 중앙값을 pivot으로 정한다.

        int i = S, j = E;
        while (i < j) { // S와 E가 만날때까지 반복
            while (pivot < A[j]) { // 피벗보다 작은수가 나올때까지 j를 왼쪽으로 이동
                j--;
            }
            while (i < j && pivot >= A[i]) { //피벗보다 큰수가 나올때까지 i를 오른쪽으로 이동
                i++;            
            }

            swap(i, j); // 찾은 i와 j의 값을 교환
        }
        A[S] = A[i];
        A[i] = pivot;

        return i;
    }

    public void swap (int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    
    void solve() {
        int ans = 0;
        quickSort(0, N-1);
        System.out.println(A[K-1]);
        //for (int x : A) System.out.print(x);
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
