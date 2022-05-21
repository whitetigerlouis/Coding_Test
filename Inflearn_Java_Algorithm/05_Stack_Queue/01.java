 /*
1. 올바른 괄호
설명
괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.
(())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.

입력
첫 번째 줄에 괄호 문자열이 입력됩니다. 문자열의 최대 길이는 30이다.

출력
첫 번째 줄에 YES, NO를 출력한다.

예시 입력 1 
(()(()))(()

예시 출력 1
NO
*/

import java.util.*;

public class Main {
    String s;
    public void inputData() {
        Scanner in = new Scanner(System.in);
        s = in.next();
        in.close();
    }

  /*
    1. 괄호가 나오는 문제는 거의 스택 자료구조를 사용하는 문제다.
    2. '('를 만나면 스택에 push한다.
    3. ')'를 만나면 스택에서 pop한다.
  */
    public String solve() {
        String answer = "YES";
        Stack<Character> stack = new Stack<>();
        for (char x : s.toCharArray()) {
            if (x=='(')
                stack.push(x);
            else {
                // ')'를 만났는데 스택에 '('이 없다면 잘못된 괄호순서이다.
                if (stack.isEmpty()) return "NO";
                stack.pop();
            }
        }
        // 비교가 끝난는데도 스택에 '('가 남아있다면 잘못된 괄호순서이다.
        if (!stack.isEmpty()) 
            return "NO";

        return answer;
    }


    public static void main(String[] args) {
        Main m = new Main();
        m.inputData();
        //for (int x : m.solve()) {
        //    System.out.print(x + " ");
        //}
        System.out.println(m.solve());
    }
}
