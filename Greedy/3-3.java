import java.util.*;

class Main {
  public static void main(String[] args) {
    // 1. 입력
    Scanner in = new Scanner(System.in);
    int n = in.nextInt(); // 배열의 크기 행 N
    int m = in.nextInt(); // 배열의 크기 열 M

    int[][] A = new int[n + 1][m + 1];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
          A[i][j] = in.nextInt();
      }
    }

    // 2. 각 항의 최소값을 얻기 위해 오름차순으로 정렬하자.
    for (int k = 0; k < n; k++) {
      for (int i = 0; i < m - 1; i++) {
        for (int j = i + 1; j < m; j++) {
          if (A[k][i] > A[k][j]) {
            int tmp = A[k][i];
            A[k][i] = A[k][j];
            A[k][j] = tmp;
          }
        }
      }
    }

    // 3. 정렬한 배열의 첫항만 비교해서 가장 큰 수를 고른다.
    int max = -1;
    for (int i = 0; i < n; i++) {
      if (max < A[i][0]) {
        max = A[i][0];
      }
    }

    // 4. 결과값 출력
    System.out.println("max number = " + max);
  }
}
