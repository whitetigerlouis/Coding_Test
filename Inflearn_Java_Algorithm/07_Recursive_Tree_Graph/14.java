 /*
14. 그래프 최단거리(BFS)

입력
6 9
1 3
1 4
2 1
2 5
3 4
4 5
4 6
6 2
6 5

출력
6
*/

import java.util.*;


public class Main {
    int n, m, answer=0;
    ArrayList<ArrayList<Integer>> graph;
    int[] checked;
    int[] dis;
    
    public void inputData() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); // 정점의 갯수
        m = in.nextInt(); // 간선의 갯수
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i=0; i<=n; i++)
            graph.add(new ArrayList<Integer>());
        
        checked = new int[n+1];
        dis = new int[n+1];
        for (int i=0; i<m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            graph.get(a).add(b); // a node에 b를 종착지로 덧붙인다.
        }
    }

    /*
    1번 정점에서 한 번만에 가는 정점 구하기
    2번 정점에서 두 번만에 가는 정점 구하기
    ...

    */
    public int BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        checked[v] = 1;
        dis[v] = 0;
        queue.offer(v);

        while(!queue.isEmpty()) {
            int cv = queue.poll(); // 현재지점
            for (int nv : graph.get(cv)) {// 정점을 꺼내서 간선으로 연결된 목적지 nv를 꺼낸다
                System.out.println("cv: "+cv+" -> nv: "+nv);
                if (checked[nv]==0) { // nv 정점을 방문 안했으면
                    checked[nv]=1; // 방문처리하고
                    queue.offer(nv); // 큐에 넣는다.
                    dis[nv] = dis[cv]+1; // 1번 정점에서 nv정점까지 가는데 걸리는 최소 거리 기록
                    System.out.println("dis[cv] = "+dis[cv]+", dis[nv] = "+dis[nv]);
                }
            }
        }

        return 0;
        
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.inputData();
        m.checked[1] = 1; // 시작정점 방문처리
        m.BFS(1);
        //System.out.println(m.answer);
        for (int i=2; i<=m.n; i++) {
            System.out.println(i+" : "+m.dis[i]);
        }
    }
}
