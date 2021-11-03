import java.util.*;

/*
    binarySearch 실전문제
    4 6
    19 15 10 17
*/
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[4];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // 시작과 끝 점 설정
        int start = 0;
        Arrays.sort(arr);
        int end = arr[n-1];

        // 이진 탐색 수행(반복문)
        int result = 0;
        while (start <= end) {
            int total = 0;
            int mid = (start + end) / 2;

            for (int i = 0; i < n; i++) {
                if (arr[i] > mid) {
                    total += arr[i] - mid;
                }
            }
            if (total < m) {
                end = mid -1;
            } else {
                result = mid;
                start = mid + 1;
            }
        }
        System.out.println(result);
    }
}
