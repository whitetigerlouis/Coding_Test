import java.util.*;

public class Main {

    public static void quickSort (int[] arr, int start, int end) {
        if (start >= end) return; // 원소가 1개이면 종료

        int pivot = start; // 피벗은 첫번째 원소로 지정
        int left = start + 1;
        int right = end;

        while (left <= right) {
            // 피벗보다 큰 데이터를 찾을 때까지 왼쪽에서 오른쪽으로 진행
            while (left <= end && arr[left] <= arr[pivot])
                left++;

            // 피벗보다 작은 데이터를 찾을 때까지 오른쪽에서 왼쪽으로 진행
            while (right > start && arr[right] >= arr[pivot])
                right--;

            // 찾았다!
            // 엇갈렸다면 작은 데이터와 피벗을 교체
            if (left > right) {
                int temp = arr[pivot];
                arr[pivot] = arr[right];
                arr[right] = temp;
            } else { // 엇갈리지 않았다면 큰 수와 작은 수를 교체
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        // 분할 이후 왼쪽 부분과 오른쪽 부분을 각각 정렬 수행
        quickSort(arr, start, right - 1);
        quickSort(arr, right + 1, end);
    }

    public static void main(String[] args) {
        int n = 10;
        int[] arr = {5, 7, 9, 0, 3, 1, 6, 2, 4, 8};

        quickSort(arr, 0, n - 1);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
