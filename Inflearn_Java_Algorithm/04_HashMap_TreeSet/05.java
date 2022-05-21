 /*
5. K번째 큰 수
설명
현수는 1부터 100사이의 자연수가 적힌 N장의 카드를 가지고 있습니다. 같은 숫자의 카드가 여러장 있을 수 있습니다.
현수는 이 중 3장을 뽑아 각 카드에 적힌 수를 합한 값을 기록하려고 합니다. 3장을 뽑을 수 있는 모든 경우를 기록합니다.
기록한 값 중 K번째로 큰 수를 출력하는 프로그램을 작성하세요.
만약 큰 수부터 만들어진 수가 25 25 23 23 22 20 19......이고 K값이 3이라면 K번째 큰 값은 22입니다.

입력
첫 줄에 자연수 N(3<=N<=100)과 K(1<=K<=50) 입력되고, 그 다음 줄에 N개의 카드값이 입력된다.

출력
첫 줄에 K번째 수를 출력합니다. K번째 수가 존재하지 않으면 -1를 출력합니다.

예시 입력 1 
10 3
13 15 34 23 45 65 33 11 26 42

예시 출력 1
143
*/

import java.util.*;

public class Main {
    int n,k;
    int[] A;
    public void inputData() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        k = in.nextInt();
        A = new int[n];
        for (int i=0; i<n; i++) {
            A[i] = in.nextInt();
        }
        in.close();
    }

  /*
    1. 중복값을 제거하기 위해서 TreeSet 자료구조를 사용한다.
  */
    public int solve() {
        int answer = -1;
        // A배열에서 3개씩 잘라낸 단어의 해쉬맵
        //HashMap<Integer, Integer> map = new HashMap<>();
        // 내림차순으로 중복값 제거해서 입력
        TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder());
        // 오름차순
        //TreeSet<Integer> Tset = new TreeSet<>();
        // 3장을 뽑는다
        for (int i=0; i<n-2; i++) {
            for (int j=i+1; j<n-1; j++) {
                for (int l=j+1; l<n; l++) {
                    Tset.add(A[i]+A[j]+A[l]);
                }
            }
        }

        int cnt=0;
        // Tset.remove(143); 143인 값을 제거
        // Tset.size(); 전체 사이즈 출력
        // Tset.first(); 첫번째 값 출력
        // Tset.last(); 마지막 값 출력
        for (int x : Tset) { 
            cnt++;
            if (cnt==k) {
                answer = x;
            }
            //System.out.println(x);
        }
        return answer;
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
