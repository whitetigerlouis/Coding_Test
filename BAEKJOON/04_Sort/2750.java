/*
[백준] 11286번: 절댓값 힙
*/
import java.io.*;
import java.util.*;

public class Main {
    int n;
    int[] A;

	void InputData() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        A = new int[n];
        for (int i=0; i<n; i++) {
            A[i] = in.nextInt();
        }
	}

    void solve() {
        int ans = 0;
        for (int i=0; i< n-1; i++) {
            for (int j=i+1; j<n; j++) {
                if (A[i] > A[j]) {
                    int temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                }
            }
        }

        for (int x : A) System.out.println(x);

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
