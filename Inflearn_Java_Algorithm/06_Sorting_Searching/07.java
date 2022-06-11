 /*
7. 좌표 정렬
설명
N개의 평면상의 좌표(x, y)가 주어지면 모든 좌표를 오름차순으로 정렬하는 프로그램을 작성하세요.
정렬기준은 먼저 x값의 의해서 정렬하고, x값이 같을 경우 y값에 의해 정렬합니다.

입력
첫째 줄에 좌표의 개수인 N(3<=N<=100,000)이 주어집니다.
두 번째 줄부터 N개의 좌표가 x, y 순으로 주어집니다. x, y값은 양수만 입력됩니다.

출력
N개의 좌표를 정렬하여 출력하세요.

예시 입력 1 
5
2 7
1 3
1 2
2 5
3 6

예시 출력 1
1 2
1 3
2 5
2 7
3 6
*/

import java.util.*;

class Point implements Comparable<Point>{
    public int x, y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Point o){
        if(this.x == o.x)
            return this.y - o.y;// x축이 같으면 y축 기준 오름차순 정렬
        else
            return this.x - o.x;// x축 기준 오름차순 정렬
    }
}

public class Main {
    int n;
    ArrayList<Point> A = new ArrayList<>();
    public void inputData() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        for (int i=0; i<n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            A.add(new Point(x,y));
        }
        in.close();
    }

  /*
    1. Comparable 타입으로 새로운 클래스를 좌표 x,y를 정의해서 사용
    2. compareTo 메소드를 override 해서 사용해야 함.
    3. Collections.sort(A)를 하면 쉽게 객체타입을 오름차순으로 정렬할 수 있다.

  */
    public ArrayList<Point> solve() {
        Collections.sort(A);
        return A;

    }

    public static void main(String[] args) {
        Main m = new Main();
        m.inputData();
        //for (int x : m.solve())
        //    System.out.print(x + " ");
        //System.out.println(m.solve());
        for(Point o : m.solve())
            System.out.println(o.x + " " + o.y);
    }
}
