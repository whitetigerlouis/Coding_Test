/*
  문제:
  1, 2, 4, 8, 16그램 추가 a, b, c, d, e개 주어진다.
  N그램 짜리 물건을 측정하는데 추의 개수를 최소로 사용하고자 한다.
  사용된 최소 개수의 추를 출력하는 프로그램을 작성하시오.

  입력형식:
  1, 2, 4, 8, 16그램 추 a, b, c, d, e개와 N이 공백으로 구분되어 입력된다.(1 <= N <= 200)

  출력형식:
  N그램 짜리 물건을 측정하는데 사용된 최소 개수의 추를 하나의 정수로 출력한다.
  주어진 입력으로 물건을 잴 수 없는 경우 impossible을 출력한다.

  입력:
  10 10 10 0 10 89

  출력:
  8
*/

import java.util.*;

class Main {
  public static void main(String[] args) {
    // 1. 입력
    Scanner in = new Scanner(System.in);
    int a = in.nextInt(); // 1그램 추의 수
    int b = in.nextInt(); // 2그램 추의 수
    int c = in.nextInt(); // 4그램 추의 수
    int d = in.nextInt(); // 8그램 추의 수
    int e = in.nextInt(); // 16그램 추의 수
    int n = in.nextInt(); // 물건의 무게

    // 2. 무게 계산
    int count = 0; // 사용한 추의 총 개수
    // 16그램 계산
    for (int i = 0; i < e; i++) {
      if (n >= 16) {
        n = n - 16;
        count++;
      } else {
        break;
      }
    }
    //System.out.println(count);
    // 8그램 계산
    for (int i = 0; i < d; i++) {
      if (n >= 8) {
        n = n - 8;
        count++;
      } else {
        break;
      }
    }
    //System.out.println(count);
    // 4그램 계산
    for (int i = 0; i < c; i++) {
      if (n >= 4) {
        n = n - 4;
        count++;
      } else {
        break;
      }
    }
    //System.out.println(count);
    // 2그램 계산
    for (int i = 0; i < b; i++) {
      if (n >= 2) {
        n = n - 2;
        count++;
      } else {
        break;
      }
    }
    //System.out.println(count);
    // 1그램 계산
    for (int i = 0; i < a; i++) {
      if (n >= 1) {
        n = n - 1;
        count++;
      } else {
        break;
      }
    }
    
    // 4. 결과값 출력
    if (n == 0) {
      System.out.println(count);
    } else {
      System.out.println("impossible");
    }
  }
}
