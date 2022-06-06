 /*
4. 후위식 연산(postfix)
설명
후위연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하세요.
만약 3*(5+2)-9 을 후위연산식으로 표현하면 352+*9- 로 표현되며 그 결과는 12입니다.

입력
첫 줄에 후위연산식이 주어집니다. 연산식의 길이는 50을 넘지 않습니다.
식은 1~9의 숫자와 +, -, *, / 연산자로만 이루어진다.

출력
연산한 결과를 출력합니다.

예시 입력 1 
352+*9-

예시 출력 1
12
*/

import java.util.*;

public class Main {
    String str;    
    public void inputData() {
        Scanner in = new Scanner(System.in);
        str = in.next();
        in.close();
    }

  /*

  */
    public int solve() {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(char x : str.toCharArray()) {
            if (Character.isDigit(x)) // 문자가 숫자이면
                stack.push(x-48); // int로 바꿔서 스택에 저장한다
            else { // + - * / 를 만나면 스택에서 숫자를 꺼내서 연산후 다시 저장한다
                int rt = stack.pop();
                int lt = stack.pop();
                if (x=='+')
                    stack.push(lt+rt);
                else if (x=='-')
                    stack.push(lt-rt);
                else if (x=='*')
                    stack.push(lt*rt);
                else if (x=='/')
                    stack.push(lt/rt);
            }
        }
        //answer = stack.get(0);
        answer = stack.pop();
        

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
