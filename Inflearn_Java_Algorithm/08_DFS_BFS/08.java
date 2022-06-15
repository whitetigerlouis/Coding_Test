 /*
8. 수열 추측하기
설명
가장 윗줄에 1부터 N까지의 숫자가 한 개씩 적혀 있다. 그리고 둘째 줄부터 차례대로 파스칼의 삼각형처럼 위의 두개를 더한 값이 저장되게 된다.
예를 들어 N이 4 이고 가장 윗 줄에 3 1 2 4 가 있다고 했을 때, 다음과 같은 삼각형이 그려진다.
Image1.jpg
N과 가장 밑에 있는 숫자가 주어져 있을 때 가장 윗줄에 있는 숫자를 구하는 프로그램을 작성하시오.
단, 답이 여러가지가 나오는 경우에는 사전순으로 가장 앞에 오는 것을 출력하여야 한다.

입력
첫째 줄에 두개의 정수 N(1≤N≤10)과 F가 주어진다.
N은 가장 윗줄에 있는 숫자의 개수를 의미하며 F는 가장 밑에 줄에 있는 수로 1,000,000 이하이다.

출력
첫째 줄에 삼각형에서 가장 위에 들어갈 N개의 숫자를 빈 칸을 사이에 두고 출력한다.
답이 존재하지 않는 경우는 입력으로 주어지지 않는다.

예시 입력 1 
4 16
예시 출력 1
3 1 2 4
*/

import java.util.*;
/*
*/

public class Main {  
    static int n, f;
    static int[] b, p, checked;
    
    public void inputData() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        f = in.nextInt();
        b = new int[n];
        p = new int[n];
        checked = new int[n+1]; // index 1부터 시작하기에 n+1개 필요함.
    }

    // 콤비네이션 함수로직
    int[][] dy = new int[35][35];
    public int combi(int n, int r) {
        if (dy[n][r]>0)
            return dy[n][r];
        if (n==r || r==0) 
            return 1;
        else 
            return dy[n][r] = combi(n-1, r-1) + combi(n-1, r);
    }

    // DFS
    boolean flag = false;
    public void DFS (int L, int sum) {
        if (flag) return;
        if (L == n) {
            if (sum == f) {
                for (int x : p) System.out.print(x+" ");
                flag = true;
            }
        } else {
            for (int i=1; i<=n; i++) {
                if (checked[i]==0){
                    checked[i]=1;
                    p[L]=i;
                    System.out.println("i: "+i+", L: "+L+", p[L]: "+p[L]+", b[L]: "+b[L]);
                    DFS(L+1, sum + (p[L] * b[L]));
                    checked[i]=0;
                }
            }
            System.out.println("----------------------------");
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.inputData();
        // 콤비네이션 배열을 미리 구한다
        System.out.print("b[n] = ");
        for (int i=0; i<n; i++) {
            b[i] = m.combi(n-1, i);
            System.out.print(b[i]+" ");
        }
        System.out.println();
        m.DFS(0, 0);
        //System.out.println(m.DFS(n, r));
    }
}
