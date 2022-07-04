/*
[1주차][개념완성 - 기본] 스택 함수 구현하기2
*/

import java.io.*;
public class Main {
	int N;//명령수
	int cmd[];
	int a[];

	int stk[];
	int sp;
	void push(int d) {
		stk[++sp] = d;
	}
	void pop() {
		sp--;

	}
	int top() {
		return stk[sp];

	}
	boolean empty(){ 
		return sp == 0;

	}
	int size() { 
		return sp;

	}
	void InputData() throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		cmd = new int[N+10];
		a = new int[N+10];
		for (int i=0; i<N; i++){
			String s[] = bf.readLine().split(" ");
			cmd[i] = Integer.parseInt(s[0]);
			if (cmd[i] == 1) a[i] = Integer.parseInt(s[1]);
		}
		bf.close();
	}
	void Solve() throws IOException{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		stk = new int[N+10];
		sp = 0;
		for (int i=0; i<N; i++){
			switch(cmd[i]){
			case 0:
				if (empty()){
					bw.write("E\n");
				}
				else {
					bw.write(String.valueOf(top()) + "\n");
					pop();
				}
				break;
			case 1:
				push(a[i]);
				break;
			case 2:
				bw.write(String.valueOf(size()) + "\n");
			}
		}
		bw.flush();
		bw.close();
	}
	public static void main(String[] args) throws IOException {
		Main m = new Main();
		m.InputData();
		m.Solve();
	}
}
