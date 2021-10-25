import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int A[][] = new int[15][15];

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                A[i][j] = in.nextInt();
            }
        }

        // 오른쪽이 벽이 아니면 이동한다.
        // 시작점은 [2][2]이다.
        int y = 2, x = 2;
        while (true) {
            // 위치가 범위를 벗어나면 종료
            if (x > 10 || y > 10) break;

            // 먹이를 찾으면 종료
            if (A[y][x] == 2) {
                A[y][x] = 9;
                System.out.println("(먹이) y = " + y + ", x = " + x);
                break;
            }

            // 우측이 길이면 이동
            if (A[y][x+1] == 0 || A[y][x+1] == 2) {
                A[y][x++] = 9;
                System.out.println("(우) y = " + y + ", x = " + x);
            } else { // 우측이 길이 아니고 아래가 길이면 이동
                if (A[y+1][x] == 0 || A[y+1][x] == 2) {
                    A[y++][x] = 9;
                    System.out.println("(하) y = " + y + ", x = " + x);
                }
            }
        }

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.print(A[i][j] + " ");
                if (j%10 == 0) System.out.println("");
            }
        }
    }
}
