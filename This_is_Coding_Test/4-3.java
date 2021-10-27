import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 1. 입력
        Scanner in = new Scanner(System.in);
        // char가 2개 연달아 입력 되는 것을 숫자로 변환해야 함. ex) a1
        String str = in.nextLine();
        // 행(row) : char 숫자에다가 '0'을 빼면 정수가 된다.
        int row = str.charAt(1) - '0';
        // 열(column) : char 알파벳에다가 -'a' +1을 하면 정수가 된다.
        int column = str.charAt(0) - 'a' + 1;
        System.out.println("row = " + row + ", column = " + column);

        // 나이트가 이동할 수 있는 8가지 방향 정의
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

        // 8가지 뱡향에 대해 이동이 가능한지 체크
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            int nextRow = row + dx[i];
            int nextCol = column + dy[i];
            // 체스판 8x8 범위 안이면 이동 카운트 1 증가
            if (nextRow >= 1 && nextRow <= 8 && nextCol >= 1 && nextCol <= 8) {
                cnt += 1;
            }
        }
        System.out.println(cnt);
    }
}
