 /*
13. 섬나라 아일랜드(BFS)
설명
N*N의 섬나라 아일랜드의 지도가 격자판의 정보로 주어집니다.
각 섬은 1로 표시되어 상하좌우와 대각선으로 연결되어 있으며, 0은 바다입니다.
섬나라 아일랜드에 몇 개의 섬이 있는지 구하는 프로그램을 작성하세요.
Image1.jpg
만약 위와 같다면 섬의 개수는 5개입니다.

입력
첫 번째 줄에 자연수 N(3<=N<=20)이 주어집니다.
두 번째 줄부터 격자판 정보가 주어진다.

출력
첫 번째 줄에 섬의 개수를 출력한다.

예시 입력 1 
7
1 1 0 0 0 1 0
0 1 1 0 1 1 0
0 1 0 0 0 0 0
0 0 0 1 0 1 1
1 1 0 1 1 0 0
1 0 0 0 1 0 0
1 0 1 0 1 0 0

예시 출력 1
5
*/

import java.util.*;
/*

*/
class Point {
    public int x, y;
    Point (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {  
    static int n;
    static int[][] board;
    static int[] dx={-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy={0, 1, 1, 1, 0, -1, -1, -1};
    static int answer=0;
    
    public void inputData() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        board = new int[n][n];
        //dis = new int[8][8];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                board[i][j] = in.nextInt();
            }
        }
    }

    // BFS - 큐를 사용한 while문
    // 1:섬, 0:바다
    public void BFS (int x, int y) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x, y)); // 이동한 위치(x,y)를 일단 큐에 넣는다.
        //board[x][y]=0; // 방문 처리 한다.
        while(!Q.isEmpty()) {
            Point tmp = Q.poll(); // Q에서 위치를 꺼낸다.
            for (int i=0; i<8; i++) { // 상,하,좌,우로 이동 체크를 한다.
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if (0<=nx && nx<n && 0<=ny && ny<n && board[nx][ny]==1) {
                    board[nx][ny]=0;// 새 섬위치를 방문처리
                    Q.offer(new Point(nx, ny)); // Q에 삽입
                    //dis[nx][ny] = dis[tmp.x][tmp.y]+1;// 이동거리를 누적해서 업데이트
                }
            }
        }
    }

    // DFS - 재귀호출
    // 1:섬, 0:바다
    public void DFS (int x, int y) {
        for (int i=0; i<8; i++) {
            int nx=x+dx[i];
            int ny=y+dy[i];
            if (0<=nx && nx<n && 0<=ny && ny<n && board[nx][ny]==1) {
                board[nx][ny]=0; // 방문처리
                DFS(nx, ny);
            }
        }
    }
    
    public void solution() {
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j]==1) {
                    answer++;
                    board[i][j]=0; // 시작점 방문처리
                    //DFS(i, j);
                    BFS(i, j);
                }
            }
        }
    }
    public static void main(String[] args) {
        Main T = new Main();
        T.inputData();
        T.solution();
        System.out.println(answer);
    }
}
