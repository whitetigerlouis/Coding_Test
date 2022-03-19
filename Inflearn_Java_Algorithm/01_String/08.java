/*
	8. 유효한 팰린드롬
	설명
	앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 팰린드롬이라고 합니다.
	문자열이 입력되면 해당 문자열이 팰린드롬이면 "YES", 아니면 “NO"를 출력하는 프로그램을 작성하세요.
	단 회문을 검사할 때 알파벳만 가지고 회문을 검사하며, 대소문자를 구분하지 않습니다.
	알파벳 이외의 문자들의 무시합니다.

	입력
	첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.

	출력
	첫 번째 줄에 팰린드롬인지의 결과를 YES 또는 NO로 출력합니다.

	예시 입력 1 
	found7, time: study; Yduts; emit, 7Dnuof

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
	1. 입력받은 문자열을 공백을 기준으로 잘라서 String[]에 넣기
	2. 
*/
  public String solve(String str) {
		/* 1. 내가 구현한 풀이방법 */
		// 알파벳을 대문자로 바꾸고 알파벳만 추출해서 문자열을 구성한 뒤, 처음과 뒤 문자를 차례대로 비교하는 방법
		String answer = "YES";
		// 모든 알파벳을 대문자로 바꾸고, 알파벳만 추출
		str = str.toUpperCase().replaceAll("[^A-Z]",""); // A부터 Z까지가 아니면 ""로 치환
		// 알파벳만 추출한 문자열의 길이
		int len = str.length();
		for (int i = 0; i < len/2; i++) {
			// 문자열의 첫글자와 마지막 글자를 비교를 시작해서 불일치 하면 NO 리턴함.
			if (str.charAt(i) != str.charAt(len-i-1)) return "NO";
		}

    /* 2. 강의 풀이방법 */
		// 알파벳을 대문자로 바꾸고 알파벳만 추출해서 문자열을 구성한 뒤, 역순으로 만든 새 문자열을 만든 뒤 그 두개를 비교하는 방법
		String answer = "NO";
		str = str.toUpperCase().replaceAll("[^A-Z]","");
		String tmp = new StringBuilder(str).reverse().toString();
		if (str.equals(tmp)) answer = "YES";

    return answer;
  }

  public static void main(String[] args) {
    Main m = new Main();
    m.inputData();
    System.out.println(m.solve(m.str)); 
  }
}
