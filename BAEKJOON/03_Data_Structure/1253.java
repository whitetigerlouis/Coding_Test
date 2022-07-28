/*
[백준] 1253번: 좋다
*/
import java.io.*;
import java.util.*;

public class Main {
    int N;
    int[] A;

	void InputData() throws IOException{
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        //M = in.nextInt();
        A = new int[N];
        for (int i=0; i<N; i++) {
            A[i] = in.nextInt();
        }
	}

    int solve() {
        int ans = 0; 
        //int s=0, e=N-1, sum=0; // 초기화 - 시작위치 설정

        // 오름차순 정렬
        Arrays.sort(A);
        //for (int x : A) System.out.print(x+" ");

        for (int i=0; i<N; i++) {
            int find = A[i];
            int s=0, e=N-1, sum=0;
            while (s < e) {
                sum = A[s]+A[e];
                //System.out.println("sum = "+sum+", find = "+find);
                if (sum == find) {
                    // find는 서로 다른 두 수의 합이어야 함.
                    // 본인 자신의 수로 조건을 만족하면 안됨
                    if (i != s && i != e) {
                        ans++;
                        break;
                    } else if (i == s) {
                        s++;
                    } else if (i == e) {
                        e--;
                    }
                } else if (sum < find) {
                    s++;
                } else if (sum > find) {
                    e--;
                }
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
