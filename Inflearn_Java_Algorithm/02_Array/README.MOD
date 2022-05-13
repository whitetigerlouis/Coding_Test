1. 큰 수 출력하기
2. 보이는 학생
3. 가위바위보



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
      
3. 정수를 뒤집기
  while (tmp > 0) {
      // ex) 123 -> 321
      //1. 나머지를 이용한 마지막 자리의 수만 잘라내기
      int t = tmp % 10;

      //2. 잘라낸 수를 한 단위 위로 올리기
      res = res*10 + t;

      //3. 나누기 10을 해서 몫만 남기고 마지막 수 버리기
      tmp = tmp / 10;
  }
  
  4. 소스인지 판단하기
    public boolean prime(int num) {
      if (num == 1) return false;
      // 1과 자신 사이에 나눠지는 약수가 또 존재하면 소수가 아니다
      for (int i = 2; i < num; i++) {
          if (num%i == 0) return false;
      }
      return true;
  }
  
  5. max값 초기화 하기
    int max = Integer.MIN_VALUE;
