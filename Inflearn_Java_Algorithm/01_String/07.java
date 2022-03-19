 /*
  7. 회문 문자열
  설명
  앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.
  문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력하는 프로그램을 작성하세요.
  단 회문을 검사할 때 대소문자를 구분하지 않습니다.
  
  입력
  첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.
  
  출력
  첫 번째 줄에 회문 문자열인지의 결과를 YES 또는 NO로 출력합니다.
  
  예시 입력 1 
  gooG
  
  예시 출력 1
  YES
*/

import java.util.*;

public class Main {
  String str;
  
  public void inputData() {
    Scanner in = new Scanner(System.in);
    str = in.nextLine(); 
    in.close();
  }

/*
  2. 입력문자열을 모두 대문자로 전환
  3. lt++, rt-- 해서 비교 시작
  4. 마지막에 string으로 변환한다.
*/
  public String solve(String str) {
    String answer = "YES";
    int len = str.length();
    str = str.toUpperCase(); // 대문자로 변경
    
    /* 1. 내가 구현한 풀이방법 */
    int lt = 0, rt = len-1;
    char[] c = str.toCharArray();
    while (lt < rt) {
      if (c[lt] == c[rt]) {
        lt++;
        rt--;
      } else {
        return "NO";
      }
    }
    /* 2. 강의 풀이방법-1 */
    for (int i = 0; i < len/2; i++) {
      if (str.charAt(i) != str.charAt(len-i-1)) return "NO";
    }

    /* 2. 강의 풀이방법-2 */
    answer = "NO";
    // 문자열을 거꾸로 만드는 방법
    String tmp = new StringBuilder(str).reverse().toString();
    // str.equalsIgnoreCase(tmp) : 대소문자 구별없이 비교하는 법
    if (str.equalsIgnoreCase(tmp)) answer = "YES";
    return answer;
  }

  public static void main(String[] args) {
    Main m = new Main();
    m.inputData();
    System.out.println(m.solve(m.str)); 
  }
}
