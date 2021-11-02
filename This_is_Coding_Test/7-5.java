import java.util.*;
/*
    1. 부품수 : N
    2. 손님이 문의한 부품수 : M
    3. 부품이 있으면 yes, 없으면 no 출력
    * 입력예시
    5
    8 3 7 9 2
    3
    5 7 9
    *출력예시
    no yes yes

*/
public class Main {
    public static int binarySearch(int[] array, int target, int start, int end) {
        if (start > end) return -1;
        int mid = (start + end) / 2;
        System.out.println("[DBG] array[mid] = " + array[mid] + ", target = " + target);

        if (array[mid] == target) {
            return target;
        } else if (array[mid] > target) {
            return binarySearch(array, target, start, mid - 1);
        } else {
            return binarySearch(array, target, mid + 1, end);
        }
    }
    public static void main(String[] args) {
        // 입력받기
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] shop = new int[n];
        for (int i = 0; i < n; i++) {
            shop[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] customer = new int[m];
        for (int i = 0; i < m; i++) {
            customer[i] = sc.nextInt();
        }

        // 올림차순 정렬
        Arrays.sort(shop);
        System.out.print("[DBG]" + " ");
        for (int i = 0; i < n; i++) {
            System.out.print(shop[i] + " ");
        }
        System.out.println(" ");

        // 이진탐색 실행
        for (int i = 0; i < m; i++) {
            int result = binarySearch(shop, customer[i], 0, n - 1);
            if (result == -1) System.out.print("no" + " ");
            else System.out.print("yes" + " ");
            System.out.println(" ");
        }
    }
}
