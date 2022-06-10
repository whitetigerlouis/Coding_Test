 /*
2. 버블 정렬
설명
N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
정렬하는 방법은 버블정렬입니다.

입력
첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.
두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다. 각 자연수는 정수형 범위 안에 있습니다.

출력
오름차순으로 정렬된 수열을 출력합니다.

예시 입력 1 
6
13 5 11 7 23 15

예시 출력 1
5 7 11 13 15 23
*/

import java.util.*;


public class Main {
    int n;
    int[] A;
    public void inputData() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        A = new int[n];
        for (int i=0; i<n; i++) {
            A[i] = in.nextInt();
        }
        in.close();
    }

  /*
버블정렬은 A[i]와 A[i+1]을 비교해서 큰 수를 뒤로 보내는 방법이다.
결국 가장 큰수가 맨 뒤로 가게되고, 다음 루프에는 다시 처음부터 맨 뒤-1번까지 비교를 한다. 이런 식으로 처음수까지 반복하면 끝난다.
  */
    public int[] solve() {
        for (int i=0; i<n-1; i++) { // n-1회 루프돌림
            for (int j=0; j<n-i-1; j++) {
                if (A[j] > A[j+1]) {// 바로 다음 수와 비교한다
                    int tmp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = tmp;
                }
            }
        }
        return A;
    }


    public static void main(String[] args) {
        Main m = new Main();
        m.inputData();
        for (int x : m.solve()) {
            System.out.print(x + " ");
        }
        //System.out.println(m.solve());
    }
}
