 /*
10. 마구간 정하기(결정알고리즘)
설명
N개의 마구간이 수직선상에 있습니다. 각 마구간은 x1, x2, x3, ......, xN의 좌표를 가지며, 마구간간에 좌표가 중복되는 일은 없습니다.
현수는 C마리의 말을 가지고 있는데, 이 말들은 서로 가까이 있는 것을 좋아하지 않습니다. 각 마구간에는 한 마리의 말만 넣을 수 있고,
가장 가까운 두 말의 거리가 최대가 되게 말을 마구간에 배치하고 싶습니다.
C마리의 말을 N개의 마구간에 배치했을 때 가장 가까운 두 말의 거리가 최대가 되는 그 최대값을 출력하는 프로그램을 작성하세요.

입력
첫 줄에 자연수 N(3<=N<=200,000)과 C(2<=C<=N)이 공백을 사이에 두고 주어집니다.
둘째 줄에 마구간의 좌표 xi(0<=xi<=1,000,000,000)가 차례로 주어집니다.

출력
첫 줄에 가장 가까운 두 말의 최대 거리를 출력하세요.

예시 입력 1 
5 3
1 2 8 4 9

예시 출력 1
3
*/

import java.util.*;


public class Main {
    int n, c;
    //ArrayList<Point> A = new ArrayList<>();
    int[] A;
    public void inputData() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        c = in.nextInt();
        A = new int[n];
        for (int i=0; i<n; i++) {
            A[i] = in.nextInt();
        }
        in.close();
    }

  /*

  */
    public int count(int dist) {
        int cnt=1;// 말의 수
        int ep=A[0]; // 말의 배치하는 마굿간의 위치
        for (int i=1; i<A.length; i++) {
            if (A[i]-ep >= dist) {
                cnt++;
                ep = A[i];
            }
        }
        return cnt;
    }
    public int solve() {
        int answer = 0;
        Arrays.sort(A); // 일단 오름차순으로 정렬한다.
        int lt = 1;
        int rt = A[n-1];
        while (lt <= rt) {
            int mid = (lt+rt)/2; // 마굿간의 간격
            if(count(mid) >= c){ // 
                answer = mid;
                lt = mid+1; // 
            } else {
                rt = mid-1; // 
            }
        }
        return answer;

    }

    public static void main(String[] args) {
        Main m = new Main();
        m.inputData();
        //for (int x : m.solve())
        //    System.out.print(x + " ");
        System.out.println(m.solve());
        //for(Point o : m.solve())
            //System.out.println(o.x + " " + o.y);
    }
}
