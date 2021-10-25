import java.util.*;

public class Main {
    public static void main(String[] args) {
        int A[][] = new int[19+1][19+1];
        Scanner in = new Scanner(System.in);
        for (int i = 1; i <= 19; i++) {
            for (int j = 1; j <= 19; j++) {
                A[i][j] = in.nextInt();
            }
        }

        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            int temp = A[x][y]; // 좌표의 값을 임시 보관
            // 십자뒤집기 시작
            // 가로축 값을 반대로 변경
            for (int j = 1; j <= 19; j++) {
                if (A[x][j] == 0) A[x][j] = 1;
                else A[x][j] = 0; 
            }
            // 세로축 값을 반대로 변경
            for (int k = 1; k <= 19; k++) {
                if (A[k][y] == 0) A[k][y] = 1;
                else A[k][y] = 0;
            }
            // 마지막에 백업한 값을 좌표에 다시 원복함
            A[x][y] = temp;
        }

        for (int i = 1; i <= 19; i++) {
            for (int j = 1; j <= 19; j++) {
                System.out.print(A[i][j] + " ");
                if (j%19 == 0) System.out.println("");
            }
        }
    }
}
