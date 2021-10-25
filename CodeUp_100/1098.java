import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int h = in.nextInt(); // 격자판 세로
        int w = in.nextInt(); // 격자판 가로
        int A[][] = new int[h+1][w+1];

        int n = in.nextInt(); // 막대의 개수
        for (int i = 0; i < n; i++) {
            int l = in.nextInt(); // 막대의 길이
            int d = in.nextInt(); // 막대 방향(0:가로, 1:세로)
            int x = in.nextInt(); // 막대 시작 좌표 x
            int y = in.nextInt(); // 막대 시작 좌표 y

            if (d == 0) { // 가로방향
                for (int j = y; j < y+l; j++) {
                    A[x][j] = 1;
                }
            } else { // 세로방향
                for (int k = x; k < x+l; k++) {
                    A[k][y] = 1;
                }
            }
        }

        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                System.out.print(A[i][j] + " ");
                if (j%w == 0) System.out.println("");
            }
        }
    }
}
