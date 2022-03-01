import java.util.*;

class Main {
  public static void main(String[] args) {
    // 1. 입력
    Scanner in = new Scanner(System.in);
    int n = in.nextInt(); // 어떤 수 N
    int k = in.nextInt(); // 나누는 수 K 

    // 2. 반복문 실행
    int count = 0;
    while(true) {
      if (n % k == 0) {
        n = n / k;
      } else {
        n = n - 1;
      }
      count++;
      
      if (n == 1) 
        break;
    }


    // 4. 결과값 출력
    System.out.println("answer = " + count);
  }
}
