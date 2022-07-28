/*
[백준] 1427번: 소트인사이드
*/
import java.io.*;
import java.util.*;

public class Main {
    int n, len;
    int[] A;

	void InputData() {
        Scanner in = new Scanner(System.in);
        //n = in.nextInt();
        String str = in.next();
        len = str.length();
        A = new int[len];
        for (int i=0; i<len; i++) {
            A[i] = Integer.parseInt(str.substring(i, i+1));
        }
	}

    void solve() {
        int ans = 0;
        for (int i=0; i<len; i++) {
            int max = i;
            for (int j=i+1; j<len; j++) {
                if (A[j] > A[max]) // 내림차순이므로 최댓값을 찾아서 인덱스 저장
                    max = j;
            }
            if (A[i] < A[max]) {// i 이후에 찾은 max값이 더 크면 교체
                int temp = A[i];
                A[i] = A[max];
                A[max] = temp;
            }
        }
        

        for (int x : A) System.out.print(x);

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
