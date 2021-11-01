import java.util.*;

// 큐에 int x, int y 좌표를 입력해야 하므로 별도의 class 구현
class Node {
    private int x;
    private int y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
}

public class Main {
    public static int n, m;
    public static int[][] graph = new int[200 + 1][200 + 1];

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};


    public static int bfs (int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));

        while(!q.isEmpty()) {
            Node node = q.poll();
            x = node.getX();
            y = node.getY();

            // 현재 위치에서 4가지 방향으로 노드 확인
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 범위를 벗어나면 무시
                if (nx <= -1 || nx >= n || ny <= -1 || ny >= n) {
                    continue;
                }
                // 벽인 경우 무시
                if (graph[nx][ny] == 0) continue;

                // 해당 노드를 처음 방문한 경우만 기록 업데이트
                if (graph[nx][ny] == 1) {
                    graph[nx][ny] = graph[x][y] + 1;
                    q.offer(new Node(nx, ny));
                }
            }
        }
        // 가장 오른쪽 아래까지의 최단 거리 반환
        return graph[n - 1][m - 1];    
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        // N x M 맵 크기 입력
        n = sc.nextInt();
        m = sc.nextInt();

        // 버퍼 비우기(중료)
        sc.nextLine();

        // 맵 정보 입력 받기
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j) - '0'; // char to int로 변환
            }
        }

        // 알고리즘 시작
        System.out.println(bfs(0, 0));
    }
}
