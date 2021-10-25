import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();

        for (int i = 1; i <= a; i++) {
            if (i%3 == 0) continue;

            System.out.print(i + " ");
        }
    }
}
