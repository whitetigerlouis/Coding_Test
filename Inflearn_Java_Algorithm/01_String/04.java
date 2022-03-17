/*
  4. 단어 뒤집기
  설명
  N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.
  
  입력
  첫 줄에 자연수 N(3<=N<=20)이 주어집니다.
  두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다. 단어는 영어 알파벳으로만 구성되어 있습니다.
  
  출력
  N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력합니다.

  예시 입력
3
good
Time
Big
  
  예시 출력
doog
emiT
giB
*/

import java.util.*;

public class Main {
  public int n;
  public String[] array;
  
  public void inputData() {
    Scanner in = new Scanner(System.in);
    n = in.nextInt();
    //in.nextLine();
    array = new String[n];
    for (int i = 0; i < n; i++) {
      array[i] = in.next();
    }
    in.close();
  }

  /*
    1. for문을 이용하는 방법
  */
  public String solve(String str) {
    char[] ch = str.toCharArray();
    // 풀이방법 #1
    int len = str.length() - 1;
    for (int j = 0; j < str.length()/2; j++) { // len/2를 하지 않으면 다시 원복 되어 버린다.
      char tmp = ch[j];
      ch[j] = ch[len];
      ch[len] = tmp;
      len--;
    }
    String answer = new String(ch);

    // 풀이방법 #2
    int lt = 0, rt = str.length() - 1;
    while (lt < rt) {
      char tmp = ch[lt];
      ch[lt] = ch[rt];
      ch[rt] = tmp;
      lt++;
      rt--;
    }
    String tmp = String.valueOf(ch);
    
    return answer;
  }

  /*
    2. StringBuilder().reverse().toString()을 이용하는 방법
  */
  public ArrayList<String> solution(int n, String[] str) {
    ArrayList<String> answer = new ArrayList<>();
    for (String x : str) {
      String tmp = new StringBuilder(x).reverse().toString();
      answer.add(tmp);
    }
    return answer;
  }

  public static void main(String[] args) {
    Main m = new Main();
    String answer;
    m.inputData();

    //(1)번 방법
    /*
    for (int i = 0; i < m.n; i++) {
      answer = m.solve(m.array[i]);
      System.out.println(answer);
    }
    */

    // (2)번 방법
    for (String x : m.solution(m.n, m.array)) {
      System.out.println(x);
    }    
  }
}
