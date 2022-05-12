 /*
9. 격자판 최대합
설명
5*5 격자판에 아래롸 같이 숫자가 적혀있습니다.
N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력합니다.

입력
첫 줄에 자연수 N이 주어진다.(2<=N<=50)
두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.

출력
최대합을 출력합니다.

예시 입력 1 
5
10 13 10 12 15
12 39 30 23 11
11 25 50 53 15
19 27 29 37 27
19 13 30 13 19

예시 출력 1
155
*/

import java.util.*;

public class Main {
    int n = 0;
    int[][] A;
    
    public void inputData() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        A = new int[n+1][n+1];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                A[i][j] = in.nextInt();
            }
        }
        in.close();
    }

  /*
    1. 
  */
    public int solve() {
        //int[] answer = new int[n];
        int max = 0;
        int sum1, sum2;
        // 1. 행/열 합산
        for (int i = 0; i < n; i++) {
            sum1 = sum2 = 0;
            for (int j = 0; j < n; j++) {
                sum1 += A[i][j]; // 행기준 합산
                sum2 += A[j][i]; // 열기준 합산
            }
            max = Math.max(max, sum1);
            max = Math.max(max, sum2);
            /*
            if (max < sum1) {
                max = sum1;
            }
            if (max < sum2) {
                max = sum2;
            }
            */
        }
        sum1 = sum2 = 0;
        
        // 2. 대각선 합산
        for (int i = 0; i < n; i++) {
            sum1 += A[i][i];
            sum2 += A[i][n-i];
        }
        max = Math.max(max, sum1);
        max = Math.max(max, sum2);
        /*
        if (max < sum1) {
            max = sum1;
        }
        if (max < sum2) {
            max = sum2;
        }
        */
        return max;
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.inputData();
        //for (int x : m.solve()) {
        //    System.out.print(x + " ");
        //}
        System.out.println(m.solve());
    }
}
