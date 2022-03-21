/*
  10. 가장 짧은 문자거리
  설명
  한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
  
  입력
  첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
  문자열의 길이는 100을 넘지 않는다.
  
  출력
  첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.
  
  예시 입력 1 
  teachermode e
  
  예시 출력 1
  1 0 1 2 1 0 1 2 2 1 0
*/

import java.util.*;

public class Main {
  String str = "";
  char ch;  
  
  public void inputData() {
    Scanner in = new Scanner(System.in);
    str = in.next();
    ch = in.next().charAt(0);
    in.close();
  }

/*
  1. 결과값은 int[]에다가 저장함.
*/
  public int[] solve(String s, char t) {
    //int answer = 0;
    /* 1. 내가 구현한 풀이방법 */
    // 실패

    /* 2. 강의 풀이방법-1 */
    // 오른쪽으로 비교 시작
    int[] answer = new int[s.length()];
    int p = 1000; // MAX 기준값 지정
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == t) {
        p = 0;
        answer[i] = p;
      } else {
        p++;
        answer[i] = p;
      }
    }
    // 왼쪽으로 비교
    p = 1000;
    for (int i = s.length()-1; i >= 0; i--) {
      if (s.charAt(i) == t) p = 0;
      else {
        p++;
        //answer[i] = Math.min(answer[i], p);
        answer[i] = (answer[i] > p) ? p : answer[i];        
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    Main m = new Main();
    m.inputData();
    //System.out.println(m.solve(m.str));
    for (int x : m.solve(m.str, m.ch)) {
      System.out.print(x + " ");
    }
  }
}
