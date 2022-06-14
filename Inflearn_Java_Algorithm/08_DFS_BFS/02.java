 /*
2. 바둑이 승차(DFS)
설명
철수는 그의 바둑이들을 데리고 시장에 가려고 한다. 그런데 그의 트럭은 C킬로그램 넘게 태울수가 없다.
철수는 C를 넘지 않으면서 그의 바둑이들을 가장 무겁게 태우고 싶다.
N마리의 바둑이와 각 바둑이의 무게 W가 주어지면, 철수가 트럭에 태울 수 있는 가장 무거운 무게를 구하는 프로그램을 작성하세요.

입력
첫 번째 줄에 자연수 C(1<=C<=100,000,000)와 N(1<=N<=30)이 주어집니다.
둘째 줄부터 N마리 바둑이의 무게가 주어진다.

출력
첫 번째 줄에 가장 무거운 무게를 출력한다.

예시 입력 1 
259 5
81
58
42
33
61

예시 출력 1
242
*/

import java.util.*;


/*
1. 부분집합은 DFS 알고리즘을 사용한다.
2. 노드를 방문할 때마다 지금까지 방문한 합(sum)을 가지고 재귀호출한다.
3. sum이 total/2이면 조건을 만족한 것이다.

*/
public class Main {
    static int answer = 0;    
    static int c, n, total = 0;
    static int[] arr;
    
    public void inputData() {
        Scanner in = new Scanner(System.in);
        c = in.nextInt();
        n = in.nextInt();
        arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = in.nextInt();
            total += arr[i]; // 총 무게의 합을 구한다.
        }
    }
    
    //boolean flag = false;// 다 검색해봐야 해서 flag는 사용하지 않는다.
    public void DFS(int L, int sum) {
        if (sum > c) return;

        if (L == n) {// 모든 원소의 경우의 수를 다 체크했다면
            if (sum <= c) {// 부분집합의 합이 C 보다 작고 그 중 가장 무거운 수
                // c > answer가 많이 나올 것이다. 그 수들 중에서 가장 큰수를 어떻게 고를까?
                answer = (sum>answer)?sum:answer;
                //answer = Math.max(answer, sum);
            }
        } else {
            DFS(L+1, sum+arr[L]); // L원소를 부분집합에 추가한 경우
            DFS(L+1, sum); // L원소를 부분집합에 추가하지 않은 경우
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.inputData();
        m.DFS(0, 0); // level과 무게 sum을 넘겨준다
        System.out.println(m.answer);
    }
}
