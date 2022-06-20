import java.util.*;

class Node {
    public int x, y;
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {  
    static int n, l, r;
    static int[][] board;
    static boolean[][] visited; // board는 인구수를 가지고 있으므로 방문처리용 별도 배열
    static int[] dx={-1, 0, 1, 0};
    static int[] dy={0, 1, 0, -1};
    static ArrayList<Node> list; // 인구 이동이 필요한 나라 리스트
    static int answer=0; // 인구이동 횟수
    
    public void inputData() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        l = in.nextInt();
        r = in.nextInt();
        board = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                board[i][j] = in.nextInt();
            }
        }
    }

    // BFS - 큐를 사용한 while문
    public int BFS (int x, int y) {
        Queue<Node> Q = new LinkedList<>();
        list = new ArrayList<>(); // 기본 BFS 로직에 추가한 사항
        
        Q.offer(new Node(x, y)); // 이동한 위치(x,y)를 일단 큐에 넣는다.
        list.add(new Node(x, y)); // 인구이동할 나라를 리스트에 추가
        visited[x][y] = true; // 방문 처리
        int sum = board[x][y]; // 나라의 인구수를 저장한다.

        while(!Q.isEmpty()) {
            Node current = Q.poll(); // Q에서 위치를 꺼낸다.
            for (int i=0; i<4; i++) { // 상,하,좌,우로 이동 체크를 한다.
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if (0<=nx && nx<n && 0<=ny && ny<n && !visited[nx][ny]) {
                    // 두 나라의 인구수 차이의 절대값
                    int diff = Math.abs(board[current.x][current.y]-board[nx][ny]);
                    if (l <= diff && diff <= r) {
                        visited[nx][ny] = true; // 새 위치를 방문처리
                        Q.offer(new Node(nx, ny)); // Q에 삽입
                        list.add(new Node(nx, ny)); // 나라리스트 추가
                        sum += board[nx][ny]; // 이동할 나라의 인구수 누적하기
                    }
                }
            }
        }
        return sum; // 한번 국경선이 열렸을 때 이동하는 연합인 나라의 총 인구수
    }

    public void changePeople(int sum) {
        int avg = sum / list.size();
        //System.out.println("changePeople : avg = "+avg);
        for (Node n : list) {
            board[n.x][n.y] = avg;
        }
    }
    
    public int solution() {
        // 인구이동이 더 이상 일어나지 않을 때까지 반복한다.
        while(true) {
            boolean isMove = false;
            visited = new boolean[n][n]; // 방문배열 초기화
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if (!visited[i][j]) {
                        int sum = BFS(i, j); // 탐색 후에 이동 가능한 나라들의 총 인구수
                        //System.out.println("BFS("+i+","+j+") : sum = "+sum);
                        //System.out.println("list.size() = "+list.size());
                        if (list.size() > 1) { // 인구이동할 나라들의 리스트
                            // 인구이동 실행
                            changePeople(sum);
                            isMove = true;
                        }
                        //printArray();
                    }
                }
            }
            if (!isMove) // 더 이상 인구이동할 나라가 없다면 루프 종료
                return answer;
            
            answer++;
            //System.out.println("answer = "+answer);
            //System.out.println("-------------------");
        }
    }

    public void printArray() {
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        Main T = new Main();
        T.inputData();
        System.out.println(T.solution());
        //System.out.println(answer);
    }
}

