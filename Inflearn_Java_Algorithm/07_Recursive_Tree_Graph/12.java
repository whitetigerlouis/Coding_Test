 /*
12. 경로탐색(DFS)
*/

import java.util.*;


public class Main {
    int n, m, answer=0;
    int[][] graph;
    int[] checked;
    public void inputData() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        graph = new int[n+1][n+1];
        checked = new int[n+1];
        for (int i=0; i<m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            graph[a][b] = 1;
        }
    }

    public int DFS(int v) {
        if (v == n) answer++; // v는 출발지점
        else {
            for (int i=1; i<=n; i++) {
                if (graph[v][i]==1 && checked[i]==0) { // v->i 간선은 처음이면 방문표시 함.
                    checked[i] = 1;
                    // 도착점인 i를 출발점으로 해서 재탐색함.
                    DFS(i);
                    //--------------------------------
                    checked[i] = 0;// stack에서 돌아온 후 checked[]는 초기화       
                }
            }
        }

        return 0;
        
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.inputData();
        m.checked[1] = 1;
        m.DFS(1);
        System.out.println(m.answer);
    }
}
