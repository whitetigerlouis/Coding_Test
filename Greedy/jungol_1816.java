/*
1, 2, 4, 8, 16그램 추가 a, b, c, d, e개 주어진다.
N그램 짜리 물건을 측정하는데 추의 개수를 최소로 사용하고자 한다.
사용된 최소 개수의 추를 출력하는 프로그램을 작성하시오.
*/
import java.util.*;

class Main {
  public static void main(String[] args) {
    // 1. 입력
    Scanner in = new Scanner(System.in);
    int m = in.nextInt(); // 최대 판자수
    int s = in.nextInt(); // 총 외양간의 수
    int c = in.nextInt(); // 소가 들어있는 수
    int[] A = new int[s + 1];
    for (int i = 0; i < c; i++) {
      A[i] = in.nextInt();
    }

    // 입력받은 배열을 내림차순으로 정렬(예외처리)
    for (int i = 0; i < c-1; i++) {
      for (int j = i+1; j < c; j++) {
        if (A[i] > A[j]) {
          int tmp = A[i];
          A[i] = A[j];
          A[j] = tmp;
        }
      }
    }
    
    // 2. 빈 외양간 찾아서 배열로 정리
    int[] B = new int[c + 1];
    int count = 0;
    for (int i = c-1; i > 0; i-- ) {
      B[count] = A[i] - A[i-1] - 1;
      //System.out.println("B[" + count + "] = " + B[count]);
      count++;
    }

    // 3. 빈외양간 배열을 내림차순으로 정리
    for (int i = 0; i < c-1; i++) {
      for (int j = i+1; j < c; j++) {
        if (B[i] < B[j]) {
          int tmp = B[i];
          B[i] = B[j];
          B[j] = tmp;
        }
      }
    }

    // 4. 결과값 계산 
    // 4-1. 판자 1개일 경우 길이 계산
    int max = A[c-1] - A[0] + 1;
    //System.out.println("max = " + max);
    // 4-2. 판자수 m > 1이면 전체 판자 길이에서 빈 외양간 수를 뺌
    if (m > 1) {
      int len = B.length;
      for (int i = 0; (i < m-1) && (i < len); i++) { // 배열 사이즈 체크 추가
        max = max - B[i];
        //System.out.println("B[" + i + "] = " + B[i]);
        //System.out.println("max - B[i] = " + max);
      }  
    }

    // 5. 결과값 출력
    System.out.println(max);
  }
}
