 /*
  9. 숫자만 추출
  설명
  문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 만듭니다.
  만약 “tge0a1h205er”에서 숫자만 추출하면 0, 1, 2, 0, 5이고 이것을 자연수를 만들면 1205이 됩니다.
  추출하여 만들어지는 자연수는 100,000,000을 넘지 않습니다.
  
  입력
  첫 줄에 숫자가 썩인 문자열이 주어집니다. 문자열의 길이는 100을 넘지 않습니다.
  
  출력
  첫 줄에 자연수를 출력합니다.
  
  예시 입력 1 
  g0en2T0s8eSoft
  
  예시 출력 1
  208
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
  1. replaceAll(정규식)을 사용해서 숫자만 추출
  2. 문자열을 정수형태로 변환(앞자리가 0이 올경우를 대비)
*/
  public int solve(String str) {
    int answer = 0;
    /* 1. 내가 구현한 풀이방법 */
    str = str.replaceAll("[^0-9]","");
    answer = Integer.parseInt(str);

    /* 2. 강의 풀이방법-1 */
    // ASCII 코드를 사용해서 구현
    // '0'(48) ~ '9'(57)
    for (char x : str.toCharArray()) {
      if (x >= 48 && x <= 57) {
        answer = answer*10 + (x-48);
        // ex) "0208"
        // 0*10 + 48-48 = 0
        // 0*10 + 51-48 = 2
        // 2*10 + 48-48 = 20
        // 20*10 + 56-48 = 208
      }
    }
    
    /* 2. 강의 풀이방법-2 */
    String ans = "";
    for (char x : str.toCharArray()) {
      if (Character.isDigit(x)) answer += x;
    }
    answer = Integer.parseInt(answer);

    return answer;
  }

  public static void main(String[] args) {
    Main m = new Main();
    m.inputData();
    System.out.println(m.solve(m.str)); 
  }
}
