1. 큰 수 출력하기



* 필수 구문
1. 결과 정수를 순서대로 쌓아서 출력
  ArrayList<Integer> answer = new ArrayList<>();
    answer.add(arr[i]);
  for (int x : m.solution(m.n, m.array)) {
    System.out.print(x + " ");
  }


2. 결과문자를 누적할 때 char[] 말고 string을 사용하자.
  String answer = "";
  answer += "A";
  출력할 때
  for(char x : answer.toCharArray())
      System.out.println(x);
      
