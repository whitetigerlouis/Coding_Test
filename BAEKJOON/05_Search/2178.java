/*
[백준] 2178번: 미로 탐색하기
*/

import java.util.*;

class Position {
    int x;
    int y;
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    int N, M;
    int [][] A;
    boolean[][] visited;

	void InputData() {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();
        A = new int[N][M];
        visited = new boolean[N][M];
        for (int i=0; i<N; i++) {
            char[] ch = in.next().toCharArray();
            for (int j=0; j<M; j++) {
                A[i][j] = ch[j] - '0';
            }
        }
    }

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    void BFS(int x, int y) {
        Queue<Position> Q = new LinkedList<Position>();
        Q.offer(new Position(x, y));
        while (!Q.isEmpty()) {
            Position pos = Q.poll();
            visited[x][y] = true;

            for (int i=0; i<4; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (A[nx][ny] != 0 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        A[nx][ny] = A[pos.x][pos.y] + 1;
                        Q.add(new Position(nx, ny));
                    }
                }
            }
        }
    }
    
    void solve() {
        BFS(0, 0);
        System.out.println(A[N-1][M-1]);
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
