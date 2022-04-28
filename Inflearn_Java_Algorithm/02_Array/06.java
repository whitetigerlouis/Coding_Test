 /*
설명
N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램을 작성하세요.

예를 들어 32를 뒤집으면 23이고, 23은 소수이다. 그러면 23을 출력한다. 단 910를 뒤집으면 19로 숫자화 해야 한다.
첫 자리부터의 연속된 0은 무시한다.

입력
첫 줄에 자연수의 개수 N(3<=N<=100)이 주어지고, 그 다음 줄에 N개의 자연수가 주어진다.
각 자연수의 크기는 100,000를 넘지 않는다.

출력
첫 줄에 뒤집은 소수를 출력합니다. 출력순서는 입력된 순서대로 출력합니다.
    
예시 입력 1 
9
32 55 62 20 250 370 200 30 100
    
예시 출력 1
23 2 73 2 3
*/

import java.util.*;

public class Main {
    int n = 0;
    int[] A;
    
    public void inputData() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        A = new int[n+1];
        for (int i=0; i<n; i++) {
            A[i] = in.nextInt();
        }
        in.close();
    }

  /*
    1. 입력된 수를 뒤집는다.
    2. 뒤집은 수가 소수이면 출력한다.
  */
    public boolean prime(int num) {
        if (num == 1) return false;
        // 1과 자신 사이에 나눠지는 약수가 존재하면 소수가 아니다
        for (int i = 2; i < num; i++) {
            if (num%i == 0) return false;
        }
        return true;
    }
    public ArrayList<Integer> solve() {
        ArrayList<Integer> answer = new ArrayList<>();
        // 수를 뒤집는 알고리즘
        for (int i = 0; i < n; i++) {
            int tmp = A[i];
            int res = 0; // 잘라낸 수를 누적
            while (tmp > 0) {
                // ex) 123 -> 321
                //1. 나머지를 이용한 마지막 자리의 수만 잘라내기
                int t = tmp % 10;
                //System.out.println("t = " + t);
                
                //2. 잘라낸 수를 한 단위 위로 올리기
                res = res*10 + t;
                //System.out.println("res = " + res);
    
                //3. 나누기 10을 해서 몫만 남기고 마지막 수 버리기
                tmp = tmp / 10;
                //System.out.println("tmp = " + tmp);
            }
            if (prime(res)) {
                answer.add(res);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.inputData();
        for (int x : m.solve()) {
            System.out.print(x + " ");
        }
    }
}
