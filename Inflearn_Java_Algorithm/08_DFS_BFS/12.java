import java.util.*;

class Position {
	int x, y;
	Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Main {
	static int m, n;
	static int[][] board, dis;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int answer=Integer.MIN_VALUE;
	static Queue<Position> Q = new LinkedList<>(); // inputData에서 써야 하므로 전역으로 뺀다.
	
	public void inputData() {
		Scanner in = new Scanner(System.in);
		m = in.nextInt();
		n = in.nextInt();
		board = new int[n+1][m+1];
		dis = new int[n+1][m+1];
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=m; j++) {
				board[i][j] = in.nextInt();
				// 출발점이 여러개이기 때문에 입력 받을 때 미리 큐에 삽입해 놓는다.
				if (board[i][j]==1) Q.offer(new Position(i, j));
			}
		}
		
	}
	
	public void BFS() {
		//Queue<Position> Q = new LinkedList<>();
		// 1. 큐가 빌 때까지 반복한다.
		while(!Q.isEmpty()) {
			//2. 큐에서 한개 가져온다.
			Position tmp = Q.poll();
			//3. 상/하/좌/우 한칸씩 이동해본다.
			for (int i=0; i<4; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				//4. 가용범위 안의 좌표이면 본격적으로 수행한다.
				if (nx>=1 && nx<=n && ny>=1 && ny<=m && board[nx][ny]==0) {
					board[nx][ny]=1; //방문처리
					Q.offer(new Position(nx,ny)); // 큐 삽입
					dis[nx][ny] = dis[tmp.x][tmp.y]+1; // 누적값 업데이트
					answer = Math.max(dis[nx][ny], answer); // 나중에 루프를 돌려도 되지만 속도를 위해 미리미리 업데이트 한다.
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		Main M = new Main();
		M.inputData();
		//Queue tmp = Q.poll();
		M.BFS();
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=m; j++) {
				if (board[i][j]==0) answer = -1;
			}
		}
		System.out.println(answer);
	}
}
