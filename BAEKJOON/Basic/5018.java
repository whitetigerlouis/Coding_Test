/*
[백준] 5018번: 수들의 합 5
*/
import java.io.*;
import java.util.*;

public class Main {
    int N;

	void InputData() throws IOException{
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
	}

    int solve() {
        int ans = 0;
        for (int i=0; i<=N-1; i++) {
            int n = N;
            for (int j=i+1; j<=N; j++) {
                n -= j;
                //System.out.println("n = "+n);
                if (n==0) {
                    ans++;
                    break;
                } else if (n<0) {
                    break;
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
