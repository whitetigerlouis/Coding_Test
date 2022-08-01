/*
[백준] 1167번: 트리의 지름
*/

import java.util.*;

class Edge {
    int e;
    int value;
    public Edge(int e, int value) {
        this.e = e;
        this.value = value;
    }
}

public class Main {
    int N, M;
    ArrayList<Edge>[] A;
    boolean[] visited;
    int[] distance;

	void InputData() {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        distance = new int[N+1];
        visited = new boolean[N+1];
        A = new ArrayList[N+1];
        for (int i=1; i<=N; i++) {
            A[i] = new ArrayList<Edge>();
        }

        for (int i=0; i<N; i++) {
            int S = in.nextInt();
            while(true) {
                int E = in.nextInt();
                if (E == -1) 
                    break;

                int V = in.nextInt();
                A[S].add(new Edge(E, V));
            }
        }

    }

    
    void BFS(int idx) {
        Queue<Integer> Q = new LinkedList<Integer>();
        Q.add(idx);
        visited[idx] = true;

        while (!Q.isEmpty()) {
            int now_node = Q.poll();
            for (Edge i : A[now_node]) {
                int e = i.e;
                int v = i.value;
                if (!visited[e]) {
                    visited[e] = true;
                    Q.add(e);
                    distance[e] = distance[now_node] + v;
                }
            }
        }
 
    }
    
    void solve() {
        
        BFS(1);
        int Max = 1;
        for (int i=2; i<=N; i++) {
            if (distance[Max] < distance[i])
                Max = i;
        }

        distance = new int[N+1];
        visited = new boolean[N+1];
        BFS(Max);

        Arrays.sort(distance);
        System.out.println(distance[N]);
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
