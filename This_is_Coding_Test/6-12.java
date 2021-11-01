import java.util.*;

/*
    배열 A는 오름차순, B는 내림차순으로 정렬한다.
    A의 제일 작은 수를 B의 큰 수와 K번 교환한다.
*/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N과 K를 입력받기
        int n = sc.nextInt();
        int k = sc.nextInt();

        // Arrays.sort()를 사용하기 위해 int가 아닌 Integer[]를 사용
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        Integer[] b = new Integer[n];
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        // 오름차순 정렬 내부함수
        Arrays.sort(a);
        // 내림차순 정렬을 위한 내부함수
        Arrays.sort(b, Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            if (a[i] < b[i]) {
                int temp = a[i];
                a[i] = b[i];
                b[i] = temp;
            }
            else break; // A의 원소가 B보다 크거나 같으면 더 이상 비교할 필요가 없다.
        }

        long result = 0; // 100,000까지니까 int 범위를 초과할 수 있기 때문에 long 사용
        for (int i = 0; i < n; i++) {
            result += a[i];
        }
        System.out.println(result);
    }
}
