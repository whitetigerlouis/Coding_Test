 /*
  11. 문자열 압축
  설명
  알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
  문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
  단 반복횟수가 1인 경우 생략합니다.
  
  입력
  첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.
  
  출력
  첫 줄에 압축된 문자열을 출력한다.
  
  예시 입력 1 
  KKHSSSSSSSE
  
  예시 출력 1
  K2HS7E
*/

import java.util.*;

public class Main {
  String str = ""; 
  
  public void inputData() {
    Scanner in = new Scanner(System.in);
    str = in.next();
    in.close();
  }

  /*
    1. 루프는 한번만 사용한다.
    2. 메인비교문 : if (i == i+1)
    3. 마지막 문자를 처리하기 위해 문자열 마지막에 " " 추가
  */
  public String solve(String s) {
    String answer = "";
    int len = s.length(), count = 1;
    s += " "; // 중요 포인트
    char[] c = s.toCharArray();

    for (int i = 0; i < len; i++) {
      if (c[i] == c[i+1]) {
        count++;
      } else {
        answer += c[i];
        if (count > 1) {
          answer += count;
        }
        count = 1;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    Main m = new Main();
    m.inputData();
    System.out.println(m.solve(m.str));
  }
}
