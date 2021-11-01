import java.util.*;

public class Main {
    public static int n, m;
    public static int[][] graph = new int[1000][1000];

    public static boolean dfs (int x, int y) {
        if (x <= -1 || x >= n || y <= -1 || y >= n) {
            return false;
        }

        // 현재 노드를 아직 방문하지 않았다면
        if (graph[x][y] == 0) {
            // 방문 처리
            graph[x][y] = 1;
            // 상, 하, 좌, 우 위치의 노드들을 재귀 호출
            dfs(x - 1, y);
            dfs(x + 1, y);
            dfs(x, y - 1);
            dfs(x, y + 1);
            // 주위가 모두 '1'이라서 더 이상 확장이 불가능하면 true 리턴
            return true;
        }
        return false;
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
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 현재 위치에서 dfs() 수행
                if (dfs(i, j)) { // 주위가 모두 1로 둘러싸여 있을 경우에만 true로 리턴 받음
                    result += 1;
                }
            }
        }
        System.out.println(result);
    }
}
