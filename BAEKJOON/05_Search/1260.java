/*
[백준] 1260번: DFS와 BFS
*/

import java.util.*;

public class Main {
    int N, M, S;
    boolean arrive;
    ArrayList<Integer>[] A;
    boolean[] visited;

	void InputData() {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();
        S = in.nextInt();
        A = new ArrayList[N+1];
        //visited = new boolean[N];
        for (int i=1; i<=N; i++) {
            A[i] = new ArrayList<Integer>();
        }
        for (int i=0; i<M; i++) {
            int s = in.nextInt();
            int e = in.nextInt();
            A[s].add(e);
            A[e].add(s);
        }
    }

    void DFS(int node) {
        System.out.print(node+" ");
        visited[node] = true;

        for (int x : A[node]) {
            if (!visited[x]) {
                DFS(x);
            }
        }
    }

    void BFS(int node) {
        Queue<Integer> Q = new LinkedList<Integer>();
        Q.add(node);
        visited[node] = true;

        while (!Q.isEmpty()) {
            int now_node = Q.poll();
            System.out.print(now_node +" ");
            for (int x : A[now_node]) {
                if (!visited[x]) {
                    visited[x] = true;
                    Q.add(x);
                }
            }
        }
    }
    
    void solve() {
        // 번호가 작은 순서대로 ArrayList 정렬하기
        for (int i = 1; i <= N; i++ ) {
            Collections.sort(A[i]);
        }
        visited = new boolean[N+1]; // 방문배열 초기화하기
        DFS(S);
        System.out.println();

        visited = new boolean[N+1]; // 방문배열 초기화하기
        BFS(S);
        System.out.println();
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
