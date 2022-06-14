/*
5. 동전교환
설명
다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?
각 단위의 동전은 무한정 쓸 수 있다.

입력
첫 번째 줄에는 동전의 종류개수 N(1<=N<=12)이 주어진다. 두 번째 줄에는 N개의 동전의 종류가 주어지고,
그 다음줄에 거슬러 줄 금액 M(1<=M<=500)이 주어진다.각 동전의 종류는 100원을 넘지 않는다.

출력
첫 번째 줄에 거슬러 줄 동전의 최소개수를 출력한다.

예시 입력 1 
3
1 2 5
15

예시 출력 1
3
*/

import java.util.*;


/*
1. 부분집합은 DFS 알고리즘을 사용한다.
2. 노드를 방문할 때마다 지금까지 방문한 합(sum)을 가지고 재귀호출한다.
3. 중복순열 문제이다. (재귀호출을 for문으로 한다)
*/

public class Main {
    static int answer = Integer.MAX_VALUE;;    
    static int m, n, total = 0;
    static Integer[] arr;
    
    public void inputData() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        arr = new Integer[n];
        for (int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        m = in.nextInt();
    }
    
    public void DFS(int L, int sum) {
        if (sum > m) return;
        if (L >= answer) return;

        // 동전의 갯수가 n보다 클 수 있기 때문에 if(L==n)은 사용하지 않는다
        if (sum == m) {// 동전의 합이 일치하면 조건 OK
            // sum이 m과 같을 때 가장 적은 수의 동전 갯수(L)
            answer = (L<answer) ? L:answer;
            //answer = Math.min(answer, L);
        } else {
            for (int i=0; i<n; i++) {
                DFS(L+1, sum+arr[i]); // L원소를 부분집합에 추가한 경우
            }
        }

    }

    public static void main(String[] args) {
        Main m = new Main();
        m.inputData();
        Arrays.sort(arr, Collections.reverseOrder());
        m.DFS(0, 0); // level과 시간 sum을 넘겨준다
        System.out.println(m.answer);
    }
}
