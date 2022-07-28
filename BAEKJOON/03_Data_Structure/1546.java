/*
    [백준] 1546번 평균구하기
*/
import java.util.*;

public class Main {  
    static int n;
    static int[] A;
    
    public void inputData() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        A = new int[n];
        for (int i=0; i<n; i++) {
            A[i] = in.nextInt();
        }
    }

    public double solution() {
        double answer = 0;
        long max = 0;
        long sum = 0;
        for (int x : A) {
            sum += x;
            if (x > max) max = x;
        }

        answer = sum * 100.0 / max / n;
        return answer;
    }
    
    public static void main(String[] args) {
        Main T = new Main();
        T.inputData();
        System.out.println(T.solution());
        //System.out.println(answer);
    }
}

