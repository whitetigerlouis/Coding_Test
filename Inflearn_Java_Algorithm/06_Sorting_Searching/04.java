 /*
4. Least Recently Used
설명
캐시메모리는 CPU와 주기억장치(DRAM) 사이의 고속의 임시 메모리로서 CPU가 처리할 작업을 저장해 놓았다가
필요할 바로 사용해서 처리속도를 높이는 장치이다. 워낙 비싸고 용량이 작아 효율적으로 사용해야 한다.
철수의 컴퓨터는 캐시메모리 사용 규칙이 LRU 알고리즘을 따른다.
LRU 알고리즘은 Least Recently Used 의 약자로 직역하자면 가장 최근에 사용되지 않은 것 정도의 의미를 가지고 있습니다.
캐시에서 작업을 제거할 때 가장 오랫동안 사용하지 않은 것을 제거하겠다는 알고리즘입니다.

Image1.jpg

캐시의 크기가 주어지고, 캐시가 비어있는 상태에서 N개의 작업을 CPU가 차례로 처리한다면 N개의 작업을 처리한 후
캐시메모리의 상태를 가장 최근 사용된 작업부터 차례대로 출력하는 프로그램을 작성하세요.


입력
첫 번째 줄에 캐시의 크기인 S(3<=S<=10)와 작업의 개수 N(5<=N<=1,000)이 입력된다.
두 번째 줄에 N개의 작업번호가 처리순으로 주어진다. 작업번호는 1 ~100 이다.

출력
마지막 작업 후 캐시메모리의 상태를 가장 최근 사용된 작업부터 차례로 출력합니다.

예시 입력 1 
5 9
1 2 3 2 6 2 3 5 7

예시 출력 1
7 5 3 2 6
*/

import java.util.*;


public class Main {
    int size, n;
    int[] A;
    public void inputData() {
        Scanner in = new Scanner(System.in);
        size = in.nextInt();
        n = in.nextInt();
        A = new int[n];
        for (int i=0; i<n; i++) {
            A[i] = in.nextInt();
        }
        in.close();
    }

  /*
삽입정렬 사용
  */
    public int[] solve() {
        int[] cache = new int[size];
        for (int x : A) {// 작업목록에서 작업을 한 개씩 가져온다
            //1. 캐시에 저장된 작업인지 확인
            int pos = -1; // 캐시에 있는 작업의 위치 관리
            for (int i=0; i<size; i++) {// 캐시에서 있는 작업인지 검색
                if (x == cache[i]) pos = i;//캐시에 있으면 그 인덱스 리턴
            }
            //2. 캐시 미스/히트일 경우 조치
            if (pos == -1) { // 캐시 미스
                // 작업을 한칸씩 뒤로 미루고 새작업을 맨 앞에 끼우는 작업을 삽입정렬로 구현
                for (int i=size-1; i>=1; i--) {
                    cache[i] = cache[i-1];// 한칸씩 뒤로 미는 작업
                }
                cache[0]=x;// 맨 앞에 삽입
            } else { // 캐시 히트
                // 히트한 작업을 삭제하고 그 위치에서 한칸씩 뒤로 밀고, 그 작업을 맨 앞에 끼우는 작업
                for (int i=pos; i>=1; i--) {
                    cache[i] = cache[i-1];
                }
                cache[0]=x;// 맨 앞에 삽입
            }
        }
        return cache;
    }


    public static void main(String[] args) {
        Main m = new Main();
        m.inputData();
        for (int x : m.solve()) {
            System.out.print(x + " ");
        }
        //System.out.println(m.solve());
    }
}
