/*
[백준] 13023번: ABCDE 친구관계 파악하기
*/

import java.util.*;

public class Main {
    int N, M;
    boolean arrive;
    ArrayList<Integer>[] A;
    boolean[] visited;

	void InputData() {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();
        A = new ArrayList[N];
        visited = new boolean[N];
        for (int i=0; i<N; i++) {
            A[i] = new ArrayList<Integer>();
        }
        for (int i=0; i<M; i++) {
            int s = in.nextInt();
            int e = in.nextInt();
            A[s].add(e);
            A[e].add(s);
        }
    }

    void DFS(int v, int depth) {
        // 종료조건
        //System.out.println("depth = "+depth);
        //if (visited[v]) return;
        if (depth == 5 || arrive) {
            arrive = true;
            return;
        }

        visited[v] = true;

        for (int x : A[v]) {
            if (!visited[x]) {
                DFS(x, depth+1);
            }
        }
        visited[v] = false; // 추가(중요!!!)
    }
    
    int solve() {
        //int ans = 0;
        arrive = false;

        for (int i=0; i<N; i++) {
            if (!visited[i]) {
                //count++;
                DFS(i, 1);
                if (arrive) break;
            }
            
        }
        if (arrive)
            return 1;
        else
            return 0;

    }

	public static void main(String[] args) {
		Main m = new Main();
		m.InputData();//입력
		//여기서부터 작성
        //m.solve();
        System.out.println(m.solve());
        //for (int x : m.solve()) {
        //    System.out.print(x+" ");
        //}
	}
}
