/*
[백준] 1920번: 원하는 정수 찾기
*/

import java.util.*;

public class Main {
    int N, M;
    int[] A, B;

	void InputData() {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        A = new int[N];
        for (int i=0; i<N; i++)
            A[i] = in.nextInt();

        M = in.nextInt();
        B = new int[M];
        for (int i=0; i<M; i++)
            B[i] = in.nextInt();
    }

    
    void solve() {
        // 배열 정렬하기
        Arrays.sort(A);

        for (int i=0; i<M; i++) {
            int target = B[i];
            //System.out.println("target= "+target);
            int s = 0, e = N-1;
            boolean found = false;
            while (s <= e) {
                int mid = (s+e)/2;
                int midV = A[mid];
                //System.out.println("s= "+s+", e= "+e+", mid= "+mid+", midV= "+midV);
                if (midV == target) {
                    found = true;
                    break;
                } else if (midV < target) {
                    s = mid+1;
                } else {
                    e = mid-1;
                }
            }
            if (found)
                System.out.println(1);
            else
                System.out.println(0);
        }
    }

	public static void main(String[] args) {
		Main m = new Main();
		m.InputData();
        
		//여기서부터 작성
        m.solve();
        //System.out.println(m.solve());
        //for (int x : m.solve()) {
        //    System.out.print(x+" ");
        //}
	}
}
