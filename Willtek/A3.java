/*
    A3: [1주차][개념완성 - 응용] 수식 계산기 (간단 버전)
*/
import java.io.*;
import java.util.*;

public class Main {
	int N;
	int [] M;
	char [] op;

    int[] stack;
    int sp;

    void push(int d) {
        stack[++sp] = d;
    }

    void pop() {
        sp--;
    }

    int top() {
       return stack[sp]; 
    }

    boolean isEmpty() {
        return sp == 0;
    }

    /*
    1. stack에 저장하는 값은 +만 할 수 있도록 가공을 해서 넣자.
    2. *, /이 걸리는 수들은 pop을 한 수와 계산을 해서 +만 하도록 push하자.
    3. 
    */
    int solve() {
        //stack = new int[N+10];
        //sp = 0;
			Stack<Integer> stack = new Stack<>();
        int ans = 0,d = 0;
        // 첫 숫자는 스택에 먼저 넣는다.
        stack.push(M[0]);
        for (int i=1; i<N; i++) {
            switch(op[i]) {
                case '*':
                    //d = top();
                    //pop();
										//System.out.println("*: d = "+d+", M[i] = "+M[i]);
                    stack.push(stack.pop()*M[i]);
                    break;
                case '/':
                    //d = top();
                    //pop();
                    stack.push(stack.pop()/M[i]);
								//System.out.println("/: d = "+d+", M[i] = "+M[i]);
                    break;
                case '+':
                    stack.push(M[i]);
								//System.out.println("+: M[i] = "+M[i]);
                    break;
                case '-':
                    stack.push(-M[i]);
								//System.out.println("-: M[i] = "+M[i]);
                    break;
            }
        }

        while(!stack.isEmpty()) {
            //ans += top();
            //pop();
					ans += stack.pop();
        }
        return ans;
    }

	public static void main(String[] args) throws IOException {
		int ans = -1;
		Main m = new Main();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		m.InputData();//입력

		//여기서부터 작성
		ans = m.solve();

		bw.write(String.valueOf(ans) + "\n");
		bw.flush();
		bw.close();
	}

	void InputData() throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		M = new int [N+10];
		op = new char [N+10];
		String s[] = bf.readLine().split(" ");
		M[0] = Integer.parseInt(s[0]);
		int end = (N - 1) * 2;
		for (int i = 1, j = 1; j <= end; i++, j+=2) {
			op[i] = s[j].charAt(0);
			M[i] = Integer.parseInt(s[j+1]);
		}
		bf.close();
	}
}
