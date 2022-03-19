 /*
6. 중복문자제거
설명
소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.
중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.

입력
첫 줄에 문자열이 입력됩니다. 문자열의 길이는 100을 넘지 않는다.

출력
첫 줄에 중복 문자가 제거된 문자열을 출력합니다.

  예시 입력 1 
  ksekkset
    
  예시 출력
  kset
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
  1. 입력받은 문자열을 char[]로 변환한다.
  2. char[]의 첫 글자와 마지막 글자부터 차례대로 비교해서 중복이 되면 후발주자를 제거한다.
  3. 한턴이 끝나면 lt++한다.
  4. 마지막에 string으로 변환한다.
*/
  public String solve(String str) {
    String answer = "";
    char[] ch = str.toCharArray(); // String을 ch[]로 변환
    char[] result = new char[str.length()];
    /* 1. 내가 구현한 풀이방법 */
/*
    int lt = 0, rt = str.length()-1;
    while (lt < rt) {
      if (ch[lt] == ch[rt]) {
        ch[rt] = ' ';
      }
      rt--;
      if (lt + 1 == rt) {
        lt++;
        rt = str.length()-1;
      }
    }

    int idx = 0;
    for (int i = 0; i < str.length(); i++) {
      if (ch[i] != ' ') {
        result[idx] = ch[i];
        idx++;
      }
    }
    answer = String.valueOf(result);
*/

    /* 2. 강의 풀이방법 */
    // indexOf(str.charAt(i))를 사용한다.
    for (int i = 0; i < str.length(); i++) {
      //System.out.println(str.charAt(i)+" "+i+" "+str.indexOf(str.charAt(i))); // 문자열에서 문자가 처음 나오는 위치를 반환함.
      if (str.indexOf(str.charAt(i)) == i)
        // 반환된 idx가 i와 다르다면 중복된 문자라는 뜻
        answer += str.charAt(i); // 문자를 누적해서 만드는 방법
    }    

    return answer;
  }

  // 알파벳인지 검사해주는 메소드 구현


  public static void main(String[] args) {
    Main m = new Main();
    String answer;
    m.inputData();
    answer = m.solve(m.str);
    System.out.println(answer); 
  }
}
