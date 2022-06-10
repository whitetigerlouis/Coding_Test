 /*
3. 삽입 정렬
설명
N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
정렬하는 방법은 삽입정렬입니다.

입력
첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.
두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다. 각 자연수는 정수형 범위 안에 있습니다.

출력
오름차순으로 정렬된 수열을 출력합니다.

예시 입력 1 
6
11 7 5 6 10 9

예시 출력 1
5 6 7 9 10 11
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

  */
    public int[] solve() {
        for (int i=1; i<n; i++) {
            int tmp = A[i], j;
            for (j=i-1; j>=0; j--) {
                if (A[j]>tmp)
                    A[j+1] = A[j];
                else
                    break;
            }
            A[j+1] = tmp;
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
