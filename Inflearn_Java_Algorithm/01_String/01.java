/*
  1. 문자 찾기
  설명
  한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램을 작성하세요.
  대소문자를 구분하지 않습니다.문자열의 길이는 100을 넘지 않습니다.
  
  입력
  첫 줄에 문자열이 주어지고, 두 번째 줄에 문자가 주어진다.
  문자열은 영어 알파벳으로만 구성되어 있습니다.
  
  출력
  첫 줄에 해당 문자의 개수를 출력한다.
  
  예시 입력
  Computercooler
  c
  
  예시 출력
  2
*/
import java.util.*;

public class Main {
  //public static char[] A = new char[100];
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String str = in.next();
    char ch = in.next().charAt(0);

    // 대소문자 없이 비교하기 위해서 모두 대문자로 변경
    String str2 = str.toUpperCase();
    char ch2 = Character.toUpperCase(ch);

    int count = 0;
    /*
    char[] A = str2.toCharArray();
    for (char c : A) {
      if (c == ch2) count++;
    }
    */
    for (char c : str2.toCharArray()) {
      if (c == ch2) count++;
    }

    System.out.println(count);
  }
}
