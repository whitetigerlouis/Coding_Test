 /*
1. 두 배열 합치기
설명
오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.

입력
첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.

출력
오름차순으로 정렬된 배열을 출력합니다.

예시 입력 1 
3
1 3 5
5
2 3 6 7 9

예시 출력 1
1 2 3 3 5 6 7 9
*/

import java.util.*;

public class Main {
    int n, m;
    int[] A, B;
    
    public void inputData() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        A = new int[n+1];
        for (int i=0; i<n; i++) {
            A[i] = in.nextInt();
        }
        m = in.nextInt();
        B = new int[m+1];
        for (int i=0; i<m; i++) {
            B[i] = in.nextInt();
        }
        in.close();
    }

  /*
    1. 하나씩 결과값을 추가해야 하는 경우 ArrayList를 사용하자.
  */
    public ArrayList<Integer> solve() {
        ArrayList<Integer> answer = new ArrayList<>();
        int p1 = 0, p2 = 0; // 각 배열의 포인터 위치
        while (p1<n && p2<m) { // 어느 한 배열이 끝까지 이동할 때까지 비교한다
            if (A[p1] < B[p2])
                answer.add(A[p1++]);
            else
                answer.add(B[p2++]);
        }
        while(p1<n)
            answer.add(A[p1++]); // A배열이 남았으면 남은 부분을 통째로 복사
        while(p2<m) 
            answer.add(B[p2++]); // B배열이 남았으면 남은 부분을 통째로 복사

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
