/*
    [백준] 11724번 연결 요소의 개수
*/
import java.util.*;

public class Main {  
    static int n, m;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    
    public void inputData() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        A = new ArrayList[n+1];
        visited = new boolean[n+1];
        for (int i=1; i<=n; i++) {
            A[i] = new ArrayList<Integer>();
        }
        //for (int x : S) System.out.print(x+" ");

        for (int i=0; i<m; i++) {
            int s = in.nextInt();
            int e = in.nextInt();
            A[s].add(e);
            A[e].add(s);
        }
    }

    public int solution() {
        int answer = 0;
        for (int i=1; i<=n; i++) {
            if (!visited[i]) {
                answer++;
                DFS(i);
            }
        }
        return answer;
    }

    static void DFS(int v) {
        if (visited[v]) {
            return;
        }
        visited[v] = true;
        for (int x : A[v]) {
            if (!visited[x]) {
                DFS(x);
            }
        }
    }
    
    public static void main(String[] args) {
        Main T = new Main();
        T.inputData();
        System.out.println(T.solution());
        //System.out.println(answer);
        //for (int x : ans)
        //    System.out.println(x);
    }
}

