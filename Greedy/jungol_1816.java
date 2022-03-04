/*
  문제:
  폭풍우 치는 어느 날 밤에 소들이 있는 외양간의 지붕과 문이 날아가 버렸다. 
  그러나 다행이도, 많은 소들이 외양간에서 대피하였다.
  소들은 긴 줄로 나란히 서서 외양간에서 밤을 보냈다. 
  어떤 외양간은 소들이 없었다. 모든 외양간은 똑같은 넓이로 되어있다.
  농부 창호는 가능한 빨리 외양간 앞쪽에 판자를 세워야 한다. 문이 날아갔기 때문이다. 
  판자 공급자는 창호가 원하는 크기대로 판자를 공급한다. 그러나 공급자가 공급하는 판자의 수는 정해져있다. 
  창호는 구입해야 하는 판자의 총길이를 최소화하기를 원한다.
  M(1≤M≤50)은 판자 공급자에게서 구입할 수 있는 최대 판자수이다. S(1≤S≤200)은 총 외양간의 수이다. 
  C(1≤C≤S)는 소가 들어 있는 외양간의 수이다. 그리고 다음 줄부터 C개의 줄까지는 소가 들어 있는 외양간의 번호이다.
  소가 들어있는 모든 외양간의 문을 M개의 판자로 막을 때 판자의 총 길이를 최소화하는 길이가 얼마인지 계산하여라.

  입력형식:
  첫 줄에는 세 개의 수가 나오는데, 이 수가 M, S, C이다. 
  두 번째 줄부터 C개의 줄까지는 소가 들어 있는 외양간의 번호이다.

  출력형식:
  M개의 판자로 소가 들어 있는 외양간을 막을 때, 판자의 총 길이를 출력한다.

  입력:
  4 50 18 
  3 
  4 
  6 
  8 
  14 
  15 
  16 
  17 
  21 
  25 
  26 
  27 
  30 
  31 
  40 
  41 
  42 
  43

  출력:
  25
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
