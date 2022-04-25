/*
	2. 보이는 학생
	설명
	선생님이 N명의 학생을 일렬로 세웠습니다. 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때, 맨 앞에 서 있는 선생님이 볼 수 있는 학생의 수를 구하는 프로그램을 작성하세요. (앞에 서 있는 사람들보다 크면 보이고, 작거나 같으면 보이지 않습니다.)

	입력
	첫 줄에 정수 N(5<=N<=100,000)이 입력된다. 그 다음줄에 N명의 학생의 키가 앞에서부터 순서대로 주어진다.

	출력
	선생님이 볼 수 있는 최대학생수를 출력한다.

	예시 입력 1 
	8
	130 135 148 140 145 150 150 153

	예시 출력 1
	5
*/

import java.util.*;

public class Main {
    int n = 0;
    int[] array;
    
    public void inputData() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        array = new int[n+1];
        for (int i=0; i<n; i++) {
            array[i] = in.nextInt();
        }
        in.close();
    }

  /*
    1. 처음 수는 무조건 보인다.
    2. 루프를 돌면서 자신의 바로 앞 수보다 큰 수이면 max를 갱신한다.
  */
    public int solve(int[] array) {
        // 1. 내 풀이방식 : 배열 사용
        int count = 1;
        int max = array[0];
        //System.out.print(array[0]+" ");
        for (int i = 1; i < n; i++) {
            if (max < array[i]) {
                //System.out.print(array[i]+" ");
                count++;
                max = array[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.inputData();
        System.out.print(m.solve(m.array));
        //m.solve(m.array);
        //for (int x : m.solution(m.n, m.array)) {
        //    System.out.print(x + " ");
        //}
    }
}
