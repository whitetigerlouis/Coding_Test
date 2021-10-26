import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 1. 입력
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // 배열의 크기 N
        in.nextLine(); // 버터 비우기
        String[] plans = in.nextLine().split(" "); // L R U D로 입력되는 문자열 받기
        int x = 1, y = 1;

        // L, R, U, D 이동 방향 정의
        int[] dy = {0, 0, -1, 1};
        int[] dx = {-1, 1, 0, 0};
        char[] movetypes = {'L', 'R', 'U', 'D'};

        // 이동 계획을 꺼내서 확인
        for (int i = 0; i < plans.length; i++) {
            char plan = plans[i].charAt(0);
            // 이동 후의 좌표 계산
            int nx = 0, ny = 0;
            for (int j = 0; j < 4; j++) {
                if (plan == movetypes[j]) {
                    ny = y + dy[j];
                    nx = x + dx[j];
                }
            }
            // 범위를 벗어나면 무시
            if (nx < 1 || nx > n || ny < 1 || ny > n) continue;

            // 이동좌표 업데이트
            y = ny;
            x = nx;
            System.out.println(y + " " + x);
        }

        System.out.println(y + " " + x);
    }
}
