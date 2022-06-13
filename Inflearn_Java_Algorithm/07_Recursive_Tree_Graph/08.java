 /*
8. 송아지 찾기 1(BFS : 상태트리탐색)
설명
현수는 송아지를 잃어버렸다. 다행히 송아지에는 위치추적기가 달려 있다.
현수의 위치와 송아지의 위치가 수직선상의 좌표 점으로 주어지면 현수는 현재 위치에서 송아지의 위치까지 다음과 같은 방법으로 이동한다.
송아지는 움직이지 않고 제자리에 있다.
현수는 스카이 콩콩을 타고 가는데 한 번의 점프로 앞으로 1, 뒤로 1, 앞으로 5를 이동할 수 있다.
최소 몇 번의 점프로 현수가 송아지의 위치까지 갈 수 있는지 구하는 프로그램을 작성하세요.

입력
첫 번째 줄에 현수의 위치 S와 송아지의 위치 E가 주어진다. 직선의 좌표 점은 1부터 10,000까지이다.

출력
점프의 최소횟수를 구한다. 답은 1이상이며 반드시 존재합니다.

예시 입력 1 
5 14

예시 출력 1
3
*/

import java.util.*;


public class Main {
    static int s, e; 
    public void inputData() {
        Scanner in = new Scanner(System.in);
        s = in.nextInt();
        e = in.nextInt();
    }

    int[] dis = {1, -1, 5};
    int[] checked;
    Queue<Integer> Q = new LinkedList<>();
    public int BFS(int s, int e) { // s: 현수의 위치, e: 송아지의 위치
        checked = new int[10001]; // index 0을 사용하지 않으므로 +1개 생성해야함.
        //1. 초기화 루틴
        checked[s] = 1;// 시작위치니까 방문표시를 한다.
        Q.offer(s); // root를 만든다.
        int L = 0; // 레벨 표시 & 점프 횟수

        //2. BFS 로직 실행
        while(!Q.isEmpty()) {// Q가 빌 때까지 반복한다.
            int len = Q.size();
            // Q의 수만큼 반복한다.
            for (int i=0; i<len; i++) {
                int x = Q.poll(); // 큐에서 한개 빼낸다.
                if (x==e) // 송아지 위치에 도달하면 점프횟수를 리턴한다.
                    return L;

                // 이동가능한 위치를 미리 계산해서 트리를 확장한다.
                for (int j=0; j<3; j++) {// 현위치에서 이동가능한 경우의 수
                    int nx = x + dis[j];
                    if (nx>=1 && nx<=10000 && checked[nx]==0) {
                        // 이동 가능한 위치는 1 <= 10000 사이어야 하고, 이미 방문한 곳이 아니면
                        checked[nx]=1; // 방문표시한다.
                        Q.offer(nx); // 큐에 위치를 삽입한다.
                    }
                }
                
            }
            L++; // 한 레벨의 서치가 끝나면 다음 레벨(점프수)로 이동한다.
        }
        return 0;
        
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.inputData();
        System.out.println(m.BFS(s, e));
    }
}
