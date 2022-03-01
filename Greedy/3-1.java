/*
  N : 배열의 크기
  M : 주어진 수들을 M번 더하여 가장 큰 수를 만든다.
  K : 배열의 특정 인덱스는 연속해서 K번 초과해서 더할 수 없다.
*/

import java.util.*;

class Main {
  public static void main(String[] args) {
    // 1. 입력
    Scanner in = new Scanner(System.in);
    int N = in.nextInt();
    int M = in.nextInt();
    int K = in.nextInt();
    int[] A = new int[N + 1];
    for (int i = 0; i < N; i++) {
      A[i] = in.nextInt();
    }

    // 2. 내림차순으로 정렬
    for (int i = 0; i < N - 1; i++) {
      for (int j = i + 1; j < N; j++) {
        if (A[i] < A[j]) {
          int tmp = A[i];
          A[i] = A[j];
          A[j] = tmp;
        }
      }
    }

    // 3-1. 큰 수부터 K번 이하로 더하고 총 M번 더하기
    int count1 = 0;
    int count2 = 0;
    int sum1 = 0;
    while (count1 < M) {
      if (count2 < K) {
        sum1 += A[0];
        count2++;
      } else {
        sum1 += A[1];
        count2 = 0;
      }
      count1++;
    }

    // 3-2. count1, count2를 사용 안하는 방식으로 개량
    // 역순으로 줄어들도록 카운트 하고 break문으로 루프 탈출
    int sum2 = 0, firstBigNum = A[0], secondBigNum = A[1];
    int m = M;
    while(true) {
      // 첫번째 큰 수 계산식
      for (int i = 0; i < K; i++) {
        if (m == 0) break;
        sum2 += firstBigNum;
        m--;
      }
      // 두번째 큰 수 계산식
      if (m == 0) break;
      sum2 += secondBigNum;
      m--;
    }

    // 3-3. 수열의 반복 법칙을 이용한 풀이
    // 첫번째 큰 수에 총 반복횟수를 구해서 곱해주고
    // 두번째 큰 수에 총 반복횟수를 구해서 곱한다.
    int count = (M / (K + 1)) * K + (M % ( K + 1));
    int sum3 = firstBigNum * count;
    sum3 += secondBigNum * (M - count);

    // 4. 결과값 출력
    System.out.println("1st answer = " + sum1);
    System.out.println("2nd answer = " + sum2);
    System.out.println("3rd answer = " + sum3);
  }
}
