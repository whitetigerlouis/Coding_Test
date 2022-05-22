 /*
2. 괄호문자제거
설명
입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하세요.

입력
첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.

출력
남은 문자만 출력한다.

예시 입력 1 
(A(BC)D)EF(G(H)(IJ)K)LM(N)

예시 출력 1
EFLM
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
        String answer = "";
        int cnt = 0;
        Stack<Character> stack = new Stack<>();
        for (char x : s.toCharArray()) {
            // '('와 ')'사이는 지나가고 답만 push하는 방식
            if (x=='(') {
                cnt++;
            } else if (x == ')') {
                cnt--;
            } else {
                if (cnt == 0)
                    stack.push(x);
            }
            /*
            // 일단 다 stack에 밀어넣고 ')'를 만나면 '('를 만날 때까지 pop해서 제거하는 방식
            if (x==')') {
                while(stack.pop() != '(')
            } else stack.push(x);
            */
        }
        for (int i=0; i<stack.size(); i++) {
            answer += stack.get(i);
        }
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
