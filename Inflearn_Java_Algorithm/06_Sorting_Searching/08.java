 /*
8. 이분검색
설명
임의의 N개의 숫자가 입력으로 주어집니다. N개의 수를 오름차순으로 정렬한 다음 N개의 수 중 한 개의 수인 M이 주어지면
이분검색으로 M이 정렬된 상태에서 몇 번째에 있는지 구하는 프로그램을 작성하세요. 단 중복값은 존재하지 않습니다.

입력
첫 줄에 한 줄에 자연수 N(3<=N<=1,000,000)과 M이 주어집니다.
두 번째 줄에 N개의 수가 공백을 사이에 두고 주어집니다.

출력
첫 줄에 정렬 후 M의 값의 위치 번호를 출력한다.

예시 입력 1 
8 32
23 87 65 12 57 32 99 81

예시 출력 1
3
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
    1. Comparable 타입으로 새로운 클래스를 좌표 x,y를 정의해서 사용
    2. compareTo 메소드를 override 해서 사용해야 함.
    3. Collections.sort(A)를 하면 쉽게 객체타입을 오름차순으로 정렬할 수 있다.

  */
    public int solve() {
        //Collections.sort(A);
        int answer = 0;
        int lt = 0, rt = n-1;
        Arrays.sort(A);
        while (lt <= rt) {
            int mid = (lt+rt)/2;
            if (m == A[mid]) return mid+1;
            else if (m < A[mid]) {
                rt = mid -1;
            } else {
                lt = mid + 1;
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
