 /*
1. 재귀함수(스택프레임)
*/

import java.util.*;

class Node {
    int data;
    Node lt, rt;
    public Node(int val) {
        data = val;
        lt=rt=null;
    }
}

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

    static int[] fibo;
    public int DFS(int n){
        if(fibo[n]>0) return fibo[n];
        if(n==1) // 종료조건을 재귀함수 제일 처음에 위치함.
            return fibo[n] = 1;
        else if(n==2)
            return fibo[n] = 1;
        else {
            return fibo[n] = DFS(n-2) + DFS(n-1);
        }

    }

    public int solve() {
        int answer = DFS(45);        
        return answer;

    }

    public static void main(String[] args) {
        Main m = new Main();
        //m.inputData();
        //System.out.println(m.DFS(5));
        //for (int x : m.solve())
        //    System.out.print(x + " ");
        //System.out.println(m.solve());
        //for(Point o : m.solve())
            //System.out.println(o.x + " " + o.y);
        int n = 45;
        fibo = new int[n+1];
        m.DFS(n);
        for (int i=1; i<=n; i++)
            System.out.print(fibo[i]+" ");
    }
}
