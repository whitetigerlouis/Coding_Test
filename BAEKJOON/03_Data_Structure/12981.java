/*
[백준] 12981번: DNA 비밀번호
*/
import java.io.*;
import java.util.*;

public class Main {
    int S, P;
    char[] DNA;
    int[] checkArr = new int[4];
    int[] myArr = new int[4];
    int checkSecret; // checkSecret가 4가 되면 비밀번호 조건에 만족한다.

	void InputData() throws IOException{
        Scanner in = new Scanner(System.in);
        S = in.nextInt();
        P = in.nextInt();
        DNA = new char[S];
        DNA = in.next().toCharArray();

        for (int i=0; i<4; i++) {
            checkArr[i] = in.nextInt();
            if (checkArr[i] == 0)
                checkSecret++; // 값이 0이면 조건 체크할 필요가 없기 때문이다.
        }
	}

    void Add(char c) {
        switch (c) {
            case 'A':
                myArr[0]++; //1. 먼저 증가 후
                if (myArr[0] == checkArr[0]) //2. 비번 조건 비교
                    checkSecret++;
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1])
                    checkSecret++;
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2])
                    checkSecret++;                
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3])
                    checkSecret++;   
                break;
        }
    }

    void Remove(char c) {
        switch (c) {
            case 'A':
                if (myArr[0] == checkArr[0])
                    checkSecret--;
                myArr[0]--;
                break;
            case 'C':
                if (myArr[1] == checkArr[1])
                    checkSecret--;
                myArr[1]--;                
                break;
            case 'G':
                if (myArr[2] == checkArr[2])
                    checkSecret--;     
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3] == checkArr[3])
                    checkSecret--;
                myArr[3]--;
                break;
        }
        
    }

    int solve() {
        int ans = 0;
        int s = 0, e = P-1;
        //int[] myArr = new int[4];

        // 초기 P만큼 문자열 처리하기
        for (int i=0; i<P; i++)
            Add(DNA[i]);

        if (checkSecret == 4)
            ans++;

        // 슬라이딩 윈도우 처리부분
        for (int i=P; i<S; i++) {
            int j = i-P;
            Add(DNA[i]);
            Remove(DNA[j]);
            if (checkSecret == 4)
                ans++;
        }
       
        return ans;
    }

	public static void main(String[] args) throws IOException {
		Main m = new Main();
		m.InputData();//입력
		//여기서부터 작성
        System.out.println(m.solve());
	}
}
