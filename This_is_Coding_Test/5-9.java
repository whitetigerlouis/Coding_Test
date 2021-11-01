import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main_BFS {

    public static boolean[] visited = new boolean[9];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    /*
        BFS 함수 구현
        1. Queue를 사용해서 방문 기록은 dequeue된 순서로 판단한다.
        2. 한 노드에 연결된 노드들은 모두 enqueue한다.
        3. queue가 empty될때까지 무한 루프 돌린다.
    */
    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start); // 시작 노드를 큐에 삽입
        visited[start] = true; // 시작점 방문 처리

        // 큐가 빌 때까지 반복
        while (!q.isEmpty()) {
            int x = q.poll(); // dequeue
            System.out.print(x + " ");
            // 해당 노드와 연결된 다른 노드들을 큐에 삽입
            for (int i = 0; i < graph.get(x).size(); i++) {
                int y = graph.get(x).get(i);
                if (!visited[y]) {
                    q.offer(y); // enqueue
                    visited[y] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        // 그래프 초기화
        for (int i = 0; i < 9; i++) {
            graph.add(new ArrayList<Integer>());
        }
        // 노드 1에 연결된 노드 정보 저장 
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);
        
        // 노드 2에 연결된 노드 정보 저장 
        graph.get(2).add(1);
        graph.get(2).add(7);
        
        // 노드 3에 연결된 노드 정보 저장 
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);
        
        // 노드 4에 연결된 노드 정보 저장 
        graph.get(4).add(3);
        graph.get(4).add(5);
        
        // 노드 5에 연결된 노드 정보 저장 
        graph.get(5).add(3);
        graph.get(5).add(4);
        
        // 노드 6에 연결된 노드 정보 저장 
        graph.get(6).add(7);
        
        // 노드 7에 연결된 노드 정보 저장 
        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);
        
        // 노드 8에 연결된 노드 정보 저장 
        graph.get(8).add(1);
        graph.get(8).add(7);

        bfs(1);
    }
}
