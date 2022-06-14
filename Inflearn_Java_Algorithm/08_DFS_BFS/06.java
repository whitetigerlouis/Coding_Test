 /*
6. 순열 구하기
10이하의 N개의 자연수가 주어지면 이 중 M개를 뽑아 일렬로 나열하는 방법을 모두 출력합니다.

▣ 입력설명
첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N) 이 주어집니다.
두 번째 줄에 N개의 자연수가 오름차순으로 주어집니다.

▣ 출력설명
첫 번째 줄에 결과를 출력합니다.
출력순서는 사전순으로 오름차순으로 출력합니다.

▣ 입력예제 1
3 2
3 6 9

▣ 출력예제 1
3 6
3 9
6 3
6 9
9 3
9 6
*/

import java.util.*;


/*
*/

public class Main {
    static int[] pm, checked, arr;    
    static int m, n;
    
    public void inputData() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        checked = new int[n];
        pm = new int[m];
    }
    
    public void DFS(int L) {
        if (L==m) {
            for (int x : pm) System.out.print(x+" ");
            System.out.println();
        } else {
            for (int i=0; i<n; i++) {
                if (checked[i]==0) {
                    checked[i]=1;
                    pm[L]=arr[i];
                    DFS(L+1);
                    checked[i]=0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.inputData();
        //Arrays.sort(arr, Collections.reverseOrder());
        m.DFS(0); // level과 시간 sum을 넘겨준다
        //System.out.println(m.answer);
    }
}
