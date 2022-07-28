/*
[백준] 1377번: 버블 소트
*/
import java.io.*;
import java.util.*;

class mData implements Comparable<mData> {
    int value;
    int index;

    public mData(int value, int index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(mData o) { // value 기준 오름차순 정렬하기
        return this.value - o.value;
    }
}

public class Main {
    int n;
    mData[] A;

	void InputData() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        A = new mData[n];
        for (int i=0; i<n; i++) {
            A[i] = new mData(in.nextInt(), i);
        }
	}

    void solve() {
        int ans = 0;
        int max = 0;
        Arrays.sort(A);
        for (int i=0; i< n; i++) {
            if (max < A[i].index - i)
                max = A[i].index - i;
        }
        System.out.println(max+1);

        //for (int x : A) System.out.println(x);

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
