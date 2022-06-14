 /*
3. 최대점수 구하기(DFS)
설명
이번 정보올림피아드대회에서 좋은 성적을 내기 위하여 현수는 선생님이 주신 N개의 문제를 풀려고 합니다.
각 문제는 그것을 풀었을 때 얻는 점수와 푸는데 걸리는 시간이 주어지게 됩니다.
제한시간 M안에 N개의 문제 중 최대점수를 얻을 수 있도록 해야 합니다.
(해당문제는 해당시간이 걸리면 푸는 걸로 간주한다, 한 유형당 한개만 풀 수 있습니다.)

입력
첫 번째 줄에 문제의 개수N(1<=N<=20)과 제한 시간 M(10<=M<=300)이 주어집니다.
두 번째 줄부터 N줄에 걸쳐 문제를 풀었을 때의 점수와 푸는데 걸리는 시간이 주어집니다.

출력
첫 번째 줄에 제한 시간안에 얻을 수 있는 최대 점수를 출력합니다.

예시 입력 1 
5 20
10 5
25 12
15 8
6 3
7 4

예시 출력 1
41
*/

import java.util.*;


/*
1. 부분집합은 DFS 알고리즘을 사용한다.
2. 노드를 방문할 때마다 지금까지 방문한 합(sum)을 가지고 재귀호출한다.
3. sum이 total/2이면 조건을 만족한 것이다.
*/

class Test {
    int score;
    int time;
    Test(int score, int time) {
        this.score = score;
        this.time = time;
    }
}

public class Main {
    static int answer = 0;    
    static int m, n, total = 0;
    static Test[] arr;
    
    public void inputData() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        arr = new Test[n];
        for (int i=0; i<n; i++) {
            int score = in.nextInt();
            int time = in.nextInt();
            arr[i] = new Test(score, time);
        }
    }
    
    //boolean flag = false;// 다 검색해봐야 해서 flag는 사용하지 않는다.
    public void DFS(int L, int time_sum, int score_sum) {
        if (time_sum > m) return;

        if (L == n) {// 모든 원소의 경우의 수를 다 체크했다면
            if (time_sum <= m) {// 부분집합의 합이 C 보다 작고 그 중 가장 무거운 수
                // c > answer가 많이 나올 것이다. 그 수들 중에서 가장 큰수를 어떻게 고를까?
                answer = (score_sum>answer) ? score_sum:answer;
                //answer = Math.max(answer, sum);
            }
        } else {
            DFS(L+1, time_sum+arr[L].time, score_sum+arr[L].score); // L원소를 부분집합에 추가한 경우
            DFS(L+1, time_sum, score_sum); // L원소를 부분집합에 추가하지 않은 경우
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.inputData();
        m.DFS(0, 0, 0); // level과 시간 sum을 넘겨준다
        System.out.println(m.answer);
    }
}
