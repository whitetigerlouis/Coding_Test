/*
    [백준] 11659번 구간 합 구하기
*/
import java.util.*;

public class Main {  
    static int n, m;
    static int[] A, S, ans;
    
    public void inputData() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        A = new int[n+1];
        S = new int[n+1];
        ans = new int[m];
        for (int i=1; i<=n; i++) {
            A[i] = in.nextInt();
            if (i==1)
                S[i] = A[i];
            else
                S[i] = S[i-1] + A[i];
        }
        //for (int x : S) System.out.print(x+" ");

        for (int i=0; i<m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            //System.out.println(S[b]-S[a-1]);
            ans[i] = S[b]-S[a-1];
        }
    }

    public double solution() {
        double answer = 0;
        return answer;
    }
    
    public static void main(String[] args) {
        Main T = new Main();
        T.inputData();
        //System.out.println(T.solution());
        //System.out.println(answer);
        for (int x : ans)
            System.out.println(x);
    }
}

