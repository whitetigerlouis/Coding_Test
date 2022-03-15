/*
   3. 문장 속 단어
  설명
  한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.
  문장속의 각 단어는 공백으로 구분됩니다.
  
  입력
  첫 줄에 길이가 100을 넘지 않는 한 개의 문장이 주어집니다. 문장은 영어 알파벳으로만 구성되어 있습니다.
  
  출력
  첫 줄에 가장 긴 단어를 출력한다. 가장 길이가 긴 단어가 여러개일 경우 문장속에서 가장 앞쪽에 위치한
  
  예시 입력
  it is time to study
  
  예시 출력
  study
*/

import java.util.*;

public class Main {
  //public String[] A = new String[100];
  String str = "";
  
  public void inputData() {
    Scanner in = new Scanner(System.in);
    //str = in.next(); // 공란을 기준으로 문자열을 받음.
    str = in.nextLine(); // 공란도 포함해서 문자열 1줄을 통째로 받음.
  }

  /*
    1. split을 사용하는 방법
    2. indexOf()와 substring()을 사용하는 방법
  */
  public String solve(String src) {
    String ans = "";
    int maxLen = Integer.MIN_VALUE;
    // 1. split을 사용하는 방법
    /*
    String[] array = src.split(" ");
    for (String s : array) {
      //System.out.println("s = " + s);
      if (maxLen < s.length()) { // 최대값 구하는 공식
        maxLen = s.length();
        ans = s;
      }
    }
    */
    // 2. indexOf()와 substring()을 사용하는 방법
    int m = Integer.MIN_VALUE, pos;
    // ' '을 찾으면 그 자리의 index를, 못 찾으면 -1을 리턴함.
    while ((pos = src.indexOf(' ')) != -1) {
      String tmp = src.substring(0, pos); // 처음부터 pos까지 자름.  
      int len = tmp.length();
      if (len > m) {
        m = len;
        ans = tmp;
      }
      // 다음을 위해 pos 뒤 부터 잘라서 새로운 문자열을 만듬
      src = src.substring(pos + 1);
    }
    // 마지막 단어만 다시 체크해줌.
    if (src.length() > m)
      ans = src;
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
