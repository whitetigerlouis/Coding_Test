/*
[백준] 2164번: 카드2
*/
import java.io.*;
import java.util.*;

public class Main {
    int n;

	void InputData() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
	}

    void solve() {
        int ans = 0;
        Queue<Integer> Q = new LinkedList<>();
        for (int i=1; i<=n; i++) {
            Q.add(i);
        }

        while (Q.size() > 1) {
            Q.poll();
            Q.add(Q.poll());
        }

        System.out.println(Q.poll());
    }

	public static void main(String[] args) {
		Main m = new Main();
		m.InputData();//입력
		//여기서부터 작성
        m.solve();
        //System.out.println(m.solve());
        //for (int x : m.solve()) {
        //    System.out.print(x+" ");
        //}
	}
}
