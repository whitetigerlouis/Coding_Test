import java.util.*;

class Node {
	private int y;
	private int x;
	
	public Node(int y, int x) {
		this.y = y;
		this.x = x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getX() {
		return this.x;
	}
}

class Main {
	
	public static int n, m;
	public static int[][] graph = new int[201][201];
	
	// 이동할 네 방향 정의 상/하/좌/우
	public static int dy[] = {-1, 1, 0, 0};
	public static int dx[] = {0, 0, -1, 1};
	
	public static int bfs(int y, int x) {
		// Queue 구현을 위해 queue 라이브러리 사용
		Queue<Node> q = new LinkedList<>();
		// 현재 노드를 큐에 집어넣기
		q.offer(new Node(y, x));
		// 큐가 빌 때까지 반복하기
		while(!q.isEmpty()) {
			Node node = q.poll(); // 빈 노드에 큐를 poll해서 받아온다.
			y = node.getY();
			x = node.getX();
			
			// 현재 위치에서 4가지 방향으로 이동이 가능한지 확인
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				// 1. 미로를 벗어난 경우 무시
				if (ny < 0 || ny >= n || nx < 0 || nx >= m )
					continue;
				
				// 2. 벽을 만나면 무시
				if (graph[ny][nx] == 0)
					continue;
				
				// 3. 해당 노드를 처음 방문하는 경우에만
				if (graph[ny][nx] == 1) {
					graph[ny][nx] = graph[y][x] + 1; //  지금까지 이동한 최단 거리를 덮어씀
					q.offer(new Node(ny, nx)); // 4가지 방향 중 유효한 노드이면 큐에 업데이트 한다.
				}
			}
		}
		// 출구의 값을 반환하면 그게 최단거리이다.
		return graph[n - 1][m - 1];
	}
	
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		
		//A = new int[n+1][m+1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				graph[i][j] = in.nextInt();
			}
		}
		int ans = bfs(0, 0);
		System.out.println(ans);
		
	}
}
