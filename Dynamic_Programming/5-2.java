import java.util.*;

/*

*/
public class Main {
    //public static int n, m;
    public static int[][] DP;
    public static int MIN(int a, int b, int c) {
        int min = Math.min(a, b);
        return Math.min(min, c);
    }

    public static int editDistance(char[] str1, char[] str2, int m, int n) {
        // 제일 위쪽 행
        for (int j = 0; j <= n; j++) {
            DP[0][j] = j;
        }
        // 제일 왼쪽 열
        for (int i = 0; i <= m; i++) {
            DP[i][0] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 두 글자가 같다면 이전 값 유지
                if (str1[i - 1] == str2[j - 1]) {
                    DP[i][j] = DP[i - 1][j - 1];
                } else { // 두 글자가 다르다면 이전 행, 이전 열, 이전 대각선 값 중 가장 작은 값 + 1해서 기록
                    DP[i][j] = MIN(DP[i][j - 1], DP[i - 1][j], DP[i - 1][j - 1]) + 1;
                    
                }
            }
        }
        return DP[m][n];
    }

    public static void main(String[] args) {
        // 1. 입력
        Scanner in = new Scanner(System.in);

        // N, M을 공백기준으로 입력
        String str1 = in.next();
        String str2 = in.next();

        char[] chArr1 = str1.toCharArray();
        char[] chArr2 = str2.toCharArray();

        int m = str1.length();
        int n = str2.length();
        DP = new int[m + 1][n + 1];
        System.out.println(str1);
        System.out.println(str2);

        int ret = editDistance(chArr1, chArr2, m, n);
        System.out.println(ret);
    }
}
