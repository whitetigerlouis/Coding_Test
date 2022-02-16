// N명의 점수가 주어질 때 상위 3명의 ID를 출력하는 프로그램을 작성하시오.
import java.util.Scanner;

public class Main {
  int N;//자료 개수
  class ST{
    int id, score;//아이디, 점수
    ST() { id = score = 0; }
    ST(int id, int score){
    this.id=id; this.score=score;
  }
}
  ST A[];
  void InputData(){
  Scanner in = new Scanner(System.in);
  N = in.nextInt();
  A = new ST [N+10];
  for (int i = 0; i < N; i++) {
    A[i] = new ST(i+1, in.nextInt());
  }
  in.close();
}
void OutputData(){
  for(int i=0;i<3;i++){
    System.out.print(A[i].id + " ");
  }
  System.out.println();
}

  void Sort (int a, int b) {
    for (int i = a; i < b-1; i++) {
      for (int j = i + 1; j < b; j++) {
        if (A[i].score < A[j].score) {
          ST tmp = A[i];
          A[i] = A[j];
          A[j] = tmp;
        } else if (A[i].score == A[j].score) {
          if (A[i].id > A[j].id) {
            ST tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
          }
        }
      }
    }
  }
public static void main(String[] args){
  Main m = new Main();

  m.InputData(); // 입력 함수

  // 코드를 작성하세요
  m.Sort(0, m.N);

  m.OutputData();//출력
  }
}
