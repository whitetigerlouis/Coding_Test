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
	static int answer=0;
	static Queue<Position> Q = new LinkedList<>();
	
	public void inputData() {
		Scanner in = new Scanner(System.in);
		m = in.nextInt();
		n = in.nextInt();
		board = new int[n+1][m+1];
		dis = new int[n+1][m+1];
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=m; j++) {
				board[i][j] = in.nextInt();
				if (board[i][j]==1) Q.offer(new Position(i, j));
			}
		}
		
	}
	
	public void BFS() {
		//Queue<Position> Q = new LinkedList<>();
		while(!Q.isEmpty()) {
			Position tmp = Q.poll();
			for (int i=0; i<4; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				if (nx>=1 && nx<=n && ny>=1 && ny<=m && board[nx][ny]==0) {
					board[nx][ny]=1;
					Q.offer(new Position(nx,ny));
					dis[nx][ny] = dis[tmp.x][tmp.y]+1;
					answer = Math.max(dis[nx][ny], answer);
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
