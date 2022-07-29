/*
[백준] 11399번: ATM 인출시간 계산하기
*/
import java.io.*;
import java.util.*;

public class Main {
    int N, len;
    int[] A;
    int[] S;

	void InputData() {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        A = new int[N];
        S = new int[N];
        for (int i=0; i<N; i++) {
            A[i] = in.nextInt();
        }
    }

    void solve() {
        int ans = 0;

        //1. 삽입정렬 구현
        for (int i=1; i<N; i++) {
            int insert_point = i;
            int insert_value = A[i];
            // 현재 범위에서 삽입위치 찾기
            for (int j=i-1; j>=0; j--) {
                if (A[j] < A[i]) { // 바로 앞의 수가 작으므로 정렬할 필요가 없다
                    insert_point = j+1;
                    break;
                }
                if (j==0) {
                    insert_point = 0;
                }
            }
            // 삽입 위치에서 i까지 데이터를 한칸씩 뒤로 밀기
            for (int j=i; j>insert_point; j--) {
                A[j] = A[j-1];
            }
            // 삽입 위치에 현재 데이터 삽입하기
            A[insert_point] = insert_value;
        }

        // 합배열 만들기
        S[0] = A[0];
        for (int i=1; i<N; i++) {
            S[i] = S[i-1] + A[i];
        }
        int sum = 0;
        for (int i=0; i<N; i++)
            sum = sum + S[i];

        System.out.println(sum);
        

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
