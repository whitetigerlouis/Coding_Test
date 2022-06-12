 /*
6. 부분집합 구하기(DFS)
*/

import java.util.*;


public class Main {
    static int n;
    static int[] ch;
    public void DFS(int L) { // L = level
        if (L==n+1){
            String tmp="";
            for (int i=1; i<=n; i++){
                if (ch[i]==1)
                    tmp += (i+" ");
            }
            if (tmp.length()>0)
                System.out.println(tmp);
        } else {
            // 부분집합이 있는 좌측 체크
            ch[L] = 1;// 있으므로 1로 변경
            DFS(L+1);// 좌측 트리 체크
            // 부분집합이 없는 우측 체크
            ch[L]=0;// 값이 없으므로 0으로 변경
            DFS(L+1);// 우측 트리 체크
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        n = 3; // 입력값
        ch = new int[n+1]; // index 1~n까지 사용하므로 n+1만큼 만든다
        T.DFS(1); // level 1부터 시작한다는 의미
    }
}
