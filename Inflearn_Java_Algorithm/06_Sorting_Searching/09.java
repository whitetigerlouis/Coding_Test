 /*
9. 뮤직비디오(결정알고리즘)
설명
지니레코드에서는 불세출의 가수 조영필의 라이브 동영상을 DVD로 만들어 판매하려 한다.
DVD에는 총 N개의 곡이 들어가는데, DVD에 녹화할 때에는 라이브에서의 순서가 그대로 유지되어야 한다.
순서가 바뀌는 것을 우리의 가수 조영필씨가 매우 싫어한다. 즉, 1번 노래와 5번 노래를 같은 DVD에 녹화하기 위해서는
1번과 5번 사이의 모든 노래도 같은 DVD에 녹화해야 한다. 또한 한 노래를 쪼개서 두 개의 DVD에 녹화하면 안된다.

지니레코드 입장에서는 이 DVD가 팔릴 것인지 확신할 수 없기 때문에 이 사업에 낭비되는 DVD를 가급적 줄이려고 한다.
고민 끝에 지니레코드는 M개의 DVD에 모든 동영상을 녹화하기로 하였다. 이 때 DVD의 크기(녹화 가능한 길이)를 최소로 하려고 한다.
그리고 M개의 DVD는 모두 같은 크기여야 제조원가가 적게 들기 때문에 꼭 같은 크기로 해야 한다.

입력
첫째 줄에 자연수 N(1≤N≤1,000), M(1≤M≤N)이 주어진다.
다음 줄에는 조영필이 라이브에서 부른 순서대로 부른 곡의 길이가 분 단위로(자연수) 주어진다.
부른 곡의 길이는 10,000분을 넘지 않는다고 가정하자.

출력
첫 번째 줄부터 DVD의 최소 용량 크기를 출력하세요.

예시 입력 1 
9 3
1 2 3 4 5 6 7 8 9

예시 출력 1
17
*/

import java.util.*;


public class Main {
    int n, m;
    //ArrayList<Point> A = new ArrayList<>();
    int[] A;
    public void inputData() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        A = new int[n];
        for (int i=0; i<n; i++) {
            //int x = in.nextInt();
            //int y = in.nextInt();
            //A.add(new Point(x,y));
            A[i] = in.nextInt();
        }
        in.close();
    }

  /*

  */
    public int count(int capacity) {
        int cnt=1;// DVD 장수
        int sum=0;// 곡의 총 시간
        for (int x : A) {
            if (sum+x > capacity) { // 누적된 노래 시간 > DVD 용량
                cnt++; // DVD 수 증가
                sum = x; // 다음곡으로 초기화해서 다시 시작
            } else {
                sum += x; // 곡 시간 계속 누적
            }
        }
        return cnt;
    }
    public int solve() {
        //Collections.sort(A);
        int answer = 0;
        int lt = Arrays.stream(A).max().getAsInt(); // 곡 중 가장 긴 노래
        int rt = Arrays.stream(A).sum(); // 곡 시간의 총 합
        while (lt <= rt) {
            int mid = (lt+rt)/2; // DVD의 총 레코딩 시간을 하나 정한다.
            if(count(mid) <= m){ // 정한 DVD의 시간으로 m장 보다 같거나 적으면 일단 저장
                answer = mid;
                rt = mid-1; // 더 적은 레코딩 시간의 DVD로도 만족하는지 시도해본다.
            } else {
                lt = mid+1; // 레코딩 시간이 부족하기에 큰쪽으로 증가시킨다.
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
