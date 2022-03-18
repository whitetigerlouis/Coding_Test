 /*
  5. 특정 문자 뒤집기
  설명
  영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
  특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.
  
  입력
  첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다.
  
  출력
  첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.
  
  예시 입력 1 
  a#b!GE*T@S
    
  예시 출력
  S#T!EG*b@a
*/

import java.util.*;

public class Main {
  String str;
  
  public void inputData() {
    Scanner in = new Scanner(System.in);
    str = in.nextLine(); 
    in.close();
  }

  public String solve(String str) {
    char[] ch = str.toCharArray(); // String을 ch[]로 변환

    // 풀이방법 #2
    int lt = 0, rt = str.length() - 1;
    while (lt < rt) { // 루프를 반만 돌리는 조건문(중요)
      /* 1. 내가 구현한 풀이방법
      // ch[lt]와 ch[rt]가 알파벳이면 두 글자를 swap한다.
      if (isAlphabet(ch[lt]) && isAlphabet(ch[rt])) {
        char tmp = ch[lt];
        ch[lt] = ch[rt];
        ch[rt] = tmp;
        lt++;
        rt--;
      } else {
        // ch[lt]가 특수문자면 skip하고 다음 글자로 이동
        if (!isAlphabet(ch[lt])) lt++;
        // ch[rt]가 특수문자면 skip하고 다음 글자로 이동
        if (!isAlphabet(ch[rt])) rt--;
      }
      */

      /* 2. 강의 풀이방법 */
      if (!Character.isAlphabetic(ch[lt])) lt++;
      else if (!Character.isAlphabetic(ch[rt])) rt--;
      else {
        char tmp = ch[lt];
        ch[lt] = ch[rt];
        ch[rt] = tmp;
        lt++;
        rt--;
      }
      //System.out.println("[DBG]lt = " + lt + "/ rt =" + rt);
    }
    String answer = String.valueOf(ch); // 문자열로 변환해준다
    return answer;
  }

  // 알파벳인지 검사해주는 메소드 구현
  public boolean isAlphabet(char c) {
    if (('A' <= c && c <='Z') || ('a' <= c && c <= 'z')) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    Main m = new Main();
    String answer;
    m.inputData();
    answer = m.solve(m.str);
    System.out.println(answer); 
  }
}
