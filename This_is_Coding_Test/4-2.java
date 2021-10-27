import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 1. 입력
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // 자연수 N
        
        // 2. 3이 포함되었는지 확인
        int cnt = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k < 60; k++) {
                    // 시간을 문자열로 변환
                    String str = Integer.toString(i);
                    str += Integer.toString(j);
                    str += Integer.toString(k);
                    //System.out.println(str);
                    // 문자열에 "3"이 포함되어 있으면 cnt++
                    if (str.contains("3")) cnt++;
                }
            }
        }
        // 4. 답 출력
        System.out.println(cnt);
    }
}
