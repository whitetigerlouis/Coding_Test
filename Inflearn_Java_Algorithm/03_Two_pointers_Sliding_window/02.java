 /*
2. 공통원소 구하기
설명
A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.

입력
첫 번째 줄에 집합 A의 크기 N(1<=N<=30,000)이 주어집니다.
두 번째 줄에 N개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
세 번째 줄에 집합 B의 크기 M(1<=M<=30,000)이 주어집니다.
네 번째 줄에 M개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
각 집합의 원소는 1,000,000,000이하의 자연수입니다.

출력
두 집합의 공통원소를 오름차순 정렬하여 출력합니다.

예시 입력 1 
5
1 3 9 5 2
5
3 2 5 7 8

예시 출력 1
2 3 5
*/

import java.util.*;

public class Main {
    int n, m;
    int[] A, B;
    
    public void inputData() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        A = new int[n];
        for (int i=0; i<n; i++) {
            A[i] = in.nextInt();
        }
        m = in.nextInt();
        B = new int[m];
        for (int i=0; i<m; i++) {
            B[i] = in.nextInt();
        }
        in.close();
    }

  /*
    1. 하나씩 결과값을 추가해야 하는 경우 ArrayList를 사용하자.
    2. for문을 2개 돌리니까 TC중 타임아웃 나는 것이 있다. while문 한개로 구현하자.
    3. 루프를 돌리기 전에 먼저 배열을 오름차순으로 정렬해놓자.
    4. while(p1<n && p2<m)
    5. if(A[i] == B[j]) ArrayList.add(a[p1++]) / p2++
    6. A[p1] < B[p2] 이면 p1을 증가하고, 반대면 p2를 증가한다. 작은 수 쪽을 한칸 증가시킨다.(오름차순 상태이므로)
  */
    public ArrayList<Integer> solve() {
        ArrayList<Integer> answer = new ArrayList<>();
        // 루프를 돌리기 전에 배열을 오름차순으로 정렬해놓자.
        Arrays.sort(A);
        Arrays.sort(B);

        int p1=0, p2=0;
        while (p1<n && p2<m) {
            if (A[p1] == B[p2]) {
                answer.add(A[p1++]);
                p2++;
            } else if (A[p1] < B[p2]) { // 수가 작은 쪽의 배열의 포인터를 이동시킨다
                p1++;
            } else {
                p2++;
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
        //System.out.println(m.solve());
    }
}
