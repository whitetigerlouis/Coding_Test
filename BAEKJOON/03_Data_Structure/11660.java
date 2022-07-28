/*
[백준] 11660번: 구간 합 구하기 5
*/
import java.io.*;
import java.util.*;

public class Main {
    int N, M;
    int[][] A, S, Q;


	void InputData() throws IOException{
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();
        A = new int[N+1][N+1];
        S = new int[N+1][N+1];
        Q = new int[M][4];
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                A[i][j] = in.nextInt();
                S[i][j] = S[i-1][j] + S[i][j-1] - S[i-1][j-1] + A[i][j];
            }
        }
        for (int i=0; i<M; i++) {
            for (int j=0; j<4; j++) {
                Q[i][j] = in.nextInt();
            }
        }
	}


    int solve(int x) {
        int ans = 0;
        int x1 = Q[x][0];
        int y1 = Q[x][1];
        int x2 = Q[x][2];
        int y2 = Q[x][3];

        //System.out.println("x1= "+x1+", y1= "+y1+", x2= "+x2+", y2= "+y2);
        //System.out.println("S[x2][y2]= "+S[x2][y2]+", S[x1][y1]="+S[x1][y1]);
        // if (x1==x2 && y1==y2) {
        //     ans = A[x1][y1];
        // } else if (x1==1 && y1==1) {
        //     ans = S[x2][y2];
        // } else {
        //     ans = S[x2][y2] - S[x1][y1];
        // }
        ans = S[x2][y2] - S[x2][y1-1] - S[x1-1][y2] + S[x1-1][y1-1];
        return ans;
    }

    

	public static void main(String[] args) throws IOException {
		int ans = -1;
		Main m = new Main();
		m.InputData();//입력

		//여기서부터 작성
        for (int i=0; i<m.M; i++) {
            System.out.println(m.solve(i));
        }
	}
}
