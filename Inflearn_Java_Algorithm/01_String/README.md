* String(문자열)
1. 문자 찾기
2. 대소문자 변환
3. 문장 속 단어(indexOf(), substring())
4. 단어 뒤집기(StringBuilder이용법 또는 직접 뒤집기)
5. 특정 문자 뒤집기(toCharArray())
6. 중복문자제거
7. 회문 문자열
8. 팰린드롬(replaceAll 정규식이용)
9. 숫자만 추출
10. 가장 짧은 문자거리
11. 문자열 압축



* 필수구문
1. String을 char[]로 변환
  char[] ch = str.toCharArray();

2. char을 대문자로 변경 후 누적시켜서 String으로 변환
  str += Character.toUpperCase(c);

3. 문자열에서 ' '를 기준으로 자르는 방법
  while ((pos = str.indexOf(' ')) != -1) 
    String tmp = str.substring(0, pos);
    str = str.substring(pos+1);

4. 문자열을 역순으로 만들어서 새로운 문자열로 만드는 방법
  String tmp = new StringBuilder(str).reverse().toString();

5. char가 알파벳인지 확인
  Character.isAlphabetic(ch);

6. ch[]을 String으로 변환
  str = String.valueOf(ch);

7. String을 배열로 만듬
  str.charAt(i);

8. 문자열에서 해당 문자가 처음 발견된 위치를 반환
  str.indexOf(str.charAt(i));

9. 대소문자 구별없이 두 문자열 비교
  str.equalsIgonreCase(tmp);

10. 문자열에서 알파벳만 추출하는 방법(정규식)
  str = str.replaceAll("[^A-Z]","");

11. 문자열에서 숫자만 추출하는 방법(정규식)
  str = str.replaceAll("[^0-9]","");

12. 문자열에서 숫자만 추출하는 방법(ASCII)
  if (x >= 48 && x <= 57)

13. 숫자 문자열을 정수로 변환하는 법
  num = (int)num * 10 + ((char)x - 48);

14. 문자가 숫자인지 확인하는 법
  if (Character.isDigit(x))

15. 둘 중 작은 수 선택
  answer[i] = Math.min(answer[i], p); -> answer[i] = (answer[i] > p) ? p : answer[i];

16. 문자열의 마지막 문자를 처리하기 위해 일부러 마지막에 " "을 추가한다.
  str = str + " ";

17. 문자열을 7자리씩 자르는 방법
    for (int i=0; i<n; i++) {
        String tmp = s.substring(0, 7);
        System.out.println(tmp);
        s = s.substring(7); // 자르고 남은 부분으로 문자열을 업데이트
    }
18. 문자열을 자르면서 특정 문자열을 골라서 치환하는 방법
  ex) 7자리를 잘라서 #은 1, *은 0으로 치환
  String tmp = s.substring(0, 7).replace('#', '1').replace('*','0');

19. 2진수로 된 문자열을 10진수 int로 변환
  int num = Integer.parseInt(tmp, 2);

20. 정수를 ASCII코드 기반으로 문자로 변환해서 덧붙임
  String str += (char)num;

