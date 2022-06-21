/*
    [백준] 11720번 숫자의 합 구하기
*/
import java.util.*;

public class Main {  
    static int n;
    static String s;
    
    public void inputData() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        s = in.next();
    }

    public int solution() {
        int answer = 0;
        for (char x : s.toCharArray()) {
            answer += x-'0'; // char to int로 변경
        }
        return answer;
    }
    
    public static void main(String[] args) {
        Main T = new Main();
        T.inputData();
        System.out.println(T.solution());
        //System.out.println(answer);
    }
}

