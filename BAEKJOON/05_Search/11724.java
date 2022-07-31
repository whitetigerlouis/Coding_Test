/*
[백준] 11724번: 연결 요소의 개수
*/

import java.util.*;

public class Main {
    int N, E;
    ArrayList<Integer>[] A;
    boolean[] visited;

	void InputData() {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        E = in.nextInt();
        A = new ArrayList[N+1];
        visited = new boolean[N+1];
        for (int i=1; i<=N; i++) {
            A[i] = new ArrayList<Integer>();
        }
        for (int i=0; i<E; i++) {
            int s = in.nextInt();
            int e = in.nextInt();
            A[s].add(e);
            A[e].add(s);
        }
    }

    void DFS(int v) {
        //System.out.println("DFS:visited["+v+"]= "+visited[v]);
        if (visited[v]) {// DFS 종료조건
            //System.out.println("return");
            return;
        }

        visited[v] = true; // DFS의 핵심 코드
        //System.out.println("visited[v] = true");
        
        for (int x : A[v]) {
            if (visited[x] == false) {
                DFS(x); // v노드에 연결된 노드 탐색 중 미방문 노드를 발견하면 재귀호출
            }
        }
        
    }
    
    int solve() {
        int count = 0;
        for (int i=1; i<=N; i++) {
            // 방문하지 않는 노드가 없을 때까지 반복하기
            if (!visited[i]) { // 방문하지 않은 노드라면...
                count++;
                //System.out.println("count= "+count);
                //System.out.println("Start DFS("+i+")");
                DFS(i);
            }
        }
        return count;
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
