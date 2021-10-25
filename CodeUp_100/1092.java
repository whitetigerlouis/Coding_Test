import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt(); // 방문주기 1
        int b = in.nextInt(); // 방문주기 2
        int c = in.nextInt(); // 방문주기 3
        int day = 1;

        while(true) {
            if (day%a == 0 && day%b == 0 && day%c == 0) {
                System.out.println(day);
                break;
            } else {
                day++;
            }
        }
    }
}
