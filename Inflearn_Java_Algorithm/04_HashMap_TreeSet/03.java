 /*
3. 매출액의 종류
설명
현수의 아빠는 제과점을 운영합니다. 현수아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 매출액의 종류를
각 구간별로 구하라고 했습니다.
만약 N=7이고 7일 간의 매출기록이 아래와 같고, 이때 K=4이면
20 12 20 10 23 17 10

각 연속 4일간의 구간의 매출종류는
첫 번째 구간은 [20, 12, 20, 10]는 매출액의 종류가 20, 12, 10으로 3이다.
두 번째 구간은 [12, 20, 10, 23]는 매출액의 종류가 4이다.
세 번째 구간은 [20, 10, 23, 17]는 매출액의 종류가 4이다.
네 번째 구간은 [10, 23, 17, 10]는 매출액의 종류가 3이다.
N일간의 매출기록과 연속구간의 길이 K가 주어지면 첫 번째 구간부터 각 구간별
매출액의 종류를 출력하는 프로그램을 작성하세요.

입력
첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.

출력
첫 줄에 각 구간의 매출액 종류를 순서대로 출력합니다.

예시 입력 1 
7 4
20 12 20 10 23 17 10

예시 출력 1
3 4 4 3
*/

import java.util.*;

public class Main {
    int n, k;
    int[] A;
    
    public void inputData() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        k = in.nextInt();
        A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = in.nextInt();
        }
        in.close();
    }

  /*
    HashMap, Sliding window, Two pointer 사용한다.
  */
    public ArrayList<Integer> solve() {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        // 1. 초기값을 세팅한다. (k-1개 만큼)
        for (int i=0; i<k-1; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0)+1);
        }

        int lt=0;
        for (int rt=k-1; rt<n; rt++) {
            // 같은 매출액이 이미 있으면 존재하는 hashmap을 ++한다.
            map.put(A[rt], map.getOrDefault(A[rt], 0)+1);
            answer.add(map.size()); //hashmap의 사이즈가 중복된 매출액의 종류와 동일하다.

            // lt에 해당하는 hashmap을 빼고, 값이 0이면 hashmap을 제거해버린다.
            map.put(A[lt], map.get(A[lt])-1);
            if (map.get(A[lt])==0)
                map.remove(A[lt]);
            lt++;
        }
        return answer;
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
