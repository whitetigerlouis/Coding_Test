import java.util.Scanner;

public class Main {
  int N;
  int A[];
  void InputData() {
    Scanner in = new Scanner(System.in);
    N = in.nextInt();
    A = new int [N+10];
    for (int i = 0; i < N; i++) {
      A[i] = in.nextInt();
    }
    in.close();
  }

  void OutputData() {
    for (int i = 0; i < N; i++) {
      System.out.print(A[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Main m = new Main();

    m.InputData();
    for (int i = 0; i < m.N - 1; i++) {
      for (int j = i + 1; j < m.N; j++) {
        if (m.A[i] > m.A[j]) {
          int tmp = m.A[i];
          m.A[i] = m.A[j];
          m.A[j] = tmp;
        }
      }
    }
    m.OutputData();
  }
}
