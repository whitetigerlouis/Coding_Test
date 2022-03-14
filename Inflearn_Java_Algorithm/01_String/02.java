/*
  2. 대소문자 변환
  설명
  대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.
  
  입력
  첫 줄에 문자열이 입력된다. 문자열의 길이는 100을 넘지 않습니다.
  문자열은 영어 알파벳으로만 구성되어 있습니다.
  
  
  출력
  첫 줄에 대문자는 소문자로, 소문자는 대문자로 변환된 문자열을 출력합니다.
  
  예시 입력
  StuDY
  
  예시 출력
  sTUdy
*/

import java.util.*;

public class Main {
  //public static char[] A = new char[100];
  String str = null;
  public void inputData() {
    Scanner in = new Scanner(System.in);
    str = in.next();
  }

  /*
    1. 각 문자가 대문자인지 소문자인지 판단해야 한다.
    2. 그 후에 대, 소문자로 변환한다.
  */
  public String solve(String src) {
    String ans = null;
    StringBuilder sb = new StringBuilder();
    for (char c : src.toCharArray()) {
      if ('a' <= c && c <= 'z') {
        char c1 = Character.toUpperCase(c);
        sb.append(c1);
      } else if ('A' <= c && c <= 'Z') {
        char c2 = Character.toLowerCase(c);
        sb.append(c2);
      }
    }
    ans = sb.toString();
    return ans;
  }

  
  
  public static void main(String[] args) {
    Main m = new Main();
    String ans;

    m.inputData();

    ans = m.solve(m.str);

    System.out.println(ans);
  }
}
