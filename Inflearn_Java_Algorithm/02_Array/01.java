 /*
    1. 큰 수 출력하기
    설명
    N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.
    (첫 번째 수는 무조건 출력한다)
    
    입력
    첫 줄에 자연수 N(1<=N<=100)이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.
    
    출력
    자신의 바로 앞 수보다 큰 수만 한 줄로 출력한다.
    
    예시 입력 1 
    6
    7 3 9 5 6 12
    
    예시 출력 1
    7 9 6 12
*/

import java.util.*;

public class Main {
    int n = 0;
    int[] array;
    
    public void inputData() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        array = new int[n+1];
        for (int i=0; i<n; i++) {
            array[i] = in.nextInt();
        }
        in.close();
    }

  /*
    1. 처음 수는 무조건 출력한다.
    2. 루프를 돌면서 자신의 바로 앞 수보다 큰 수이면 출력한다.
  */
    public void solve(int[] array) {
        // 1. 내 풀이방식 : 배열 사용
        System.out.print(array[0]+" ");
        for (int i = 1; i < n; i++) {
            if (array[i] > array[i-1]) {
                System.out.print(array[i]+" ");
            }
        }
    }

    // 2. 강의 풀이방식 : arrayList 사용
    public ArrayList<Integer> solution (int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);
        for (int i=1; i<n; i++) {
            if (arr[i]>arr[i-1])
                answer.add(arr[i]);
        }
        return answer;
    }
    public static void main(String[] args) {
        Main m = new Main();
        m.inputData();
        //m.solve(m.array);
        for (int x : m.solution(m.n, m.array)) {
            System.out.print(x + " ");
        }
    }
}
