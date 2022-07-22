/*
[백준] 1874번: 스택으로 오름차순 수열 만들기
*/
import java.io.*;
import java.util.*;

public class Main {
    int n;
    int[] A;

	void InputData() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        A = new int[n];
        for (int i=0; i<n; i++) {
            A[i] = in.nextInt();
        }
	}

    void solve() {
        int ans = 0;
        int num = 1; // 자연수
        boolean result = true;
        StringBuffer bf = new StringBuffer();
        Stack <Integer> stack = new Stack<>();
        for (int i=0; i<n; i++) {
            int su = A[i];
            if (su >= num) {
                while (su >= num) { //num이 su와 같아질 때까지 push 한다
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop(); //su==num이면 pop한다.
                bf.append("-\n");
            } else { // num < su
                int n = stack.pop();
                if (n > su) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    bf.append("-\n");
                }
            } 
        }
        if (result)
            System.out.println(bf.toString());
        //return ans;
    }

	public static void main(String[] args) {
		Main m = new Main();
		m.InputData();//입력
		//여기서부터 작성
        m.solve();
        //System.out.println(m.solve());
	}
}
