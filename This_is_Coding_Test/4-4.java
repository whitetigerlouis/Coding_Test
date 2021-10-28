import java.util.*;

/*
    1. 캐릭터는 왼쪽 방향으로만 반시계 방향 90도씩 회전 할 수 있다.
    (서 -> 남 -> 동 -> 북)
    2. 왼쪽에 안 가본 칸이 존재하면, 회전 후 1칸 전진
    안 가본 칸이 없으면 회전만 가능
    4. 네 방향 모두 가본 칸이거나 바다로 되어 있으면, 보는 방향을 유지한 채 한 칸 뒤로 간다.
    이때 뒤가 바다이면 움직임을 멈춘다. 
*/
public class Main {
    public static int n, m, x, y, direction;
    // 방문한 위치를 저장하기 위한 맵(0으로 초기화)
    public static int[][] visited = new int[50][50];
    // 실제 맵
    public static int[][] map = new int[50][50];
    
    // 북, 동, 남, 서 방향 정의(순서 중요)
    public static int dx[] = {-1, 0, 1, 0};
    public static int dy[] = {0, 1, 0, -1};

    // 왼쪽으로 회전
    public static void turn_left() {
        // 방향 0:북, 1:동, 2:남, 3:서
        // 반시계 방향으로 돌려면 숫자-1 씩 감소해야 한다
        direction = direction - 1;
        // 4방향 다 돌았으면 다시 처음 방향으로 세팅
        if (direction == -1) direction = 3;
    }

    public static void main(String[] args) {
        // 1. 입력
        Scanner in = new Scanner(System.in);

        // N, M을 공백기준으로 입력
        n = in.nextInt();
        m = in.nextInt();

        // 캐릭터의 초기 위치, 방향 입력
        x = in.nextInt();
        y = in.nextInt();
        direction = in.nextInt();
        visited[x][y] = 1; // 처음 위치는 방문 처리

        // 전체 맵 정보 입력 받기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = in.nextInt();
            }
        }

        // 시물레이션 시작
        int cnt = 1;
        int turn_time = 0;
        while(true) {
            // 1. 왼쪽으로 회전: step 1
            turn_left();
            int nx = x + dx[direction];
            int ny = y + dy[direction];
            //System.out.println("nx = " + nx + ", ny = " + ny);
            
            // 2. 회전 후 정면에 가보지 않은 위치가 있으면 이동
            if (visited[nx][ny] == 0 && map[nx][ny] == 0) {
                visited[nx][ny] = 1; // 방문처리
                x = nx; // 이동 후 위치로 재설정
                y = ny;
                cnt += 1; // 방문횟수 1 증가
                turn_time = 0; // 회전횟수 초기화
                //System.out.println("[FOUND] x = " + x + ", y = " + y);
                continue; // 이동 했으니 다시 step 1으로
            } else {
                // 3. 회전 후 정면에 가보지 않은 칸이 없거나 바다인 경우
                turn_time += 1; // 회전횟수 1 증가
            }
            //System.out.println("turn_time = " + turn_time);

            // 4. 다 회전 했으나 네 방향 모두 이동 못하는 경우
            if (turn_time == 4) {
                // 뒤로 갈 수 있으면 이동하기
                nx = x - dx[direction];
                ny = y - dy[direction];
                if (map[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                } else {
                    // 뒤도 바다인 경우
                    //System.out.println("break");
                    break;
                }
                // 0으로 초기화하지 않으면 무한루프
                turn_time = 0;
            }
        }
        System.out.println(cnt);
    }
}
