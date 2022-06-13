 /*
13. 경로탐색(인접리스트, ArrayList)

입력
5 9
1 2
1 3
1 4
2 1
2 3
2 5
3 4
4 2
4 5

출력
6
*/

import java.util.*;


public class Main {
    int n, m, answer=0;
    ArrayList<ArrayList<Integer>> graph;
    int[] checked;
    
    public void inputData() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i=0; i<=n; i++)
            graph.add(new ArrayList<Integer>());
        
        checked = new int[n+1];
        for (int i=0; i<m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            graph.get(a).add(b); // a node에 b를 종착지로 덧붙인다.
        }
    }

    public int DFS(int v) {
        if (v == n) answer++; // v는 출발지점
        else {
            for (int nv : graph.get(v)) {// v->nv를 얻어옴
                if (checked[nv]==0) {
                    checked[nv]=1;

                    DFS(nv);// 종착지를 시작점으로 해서 DFS를 재귀호출함.
                    //---------------------
                    checked[nv]=0; // 재귀에서 돌아오면 방문표시 초기화
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
