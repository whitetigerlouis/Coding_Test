/*
    문제:
    회의실이 하나 있다. 여러 회의들이 시작시간과 종료시간이 예약되어 있으며, 시간대가 겹치는 회의는 동시에 개최가 불가능하다. 
    따라서 같은 시간대에 속하는 회의들 중 하나만 개최하고 나머지 회의들은 버려야한다. 
    단, 종료시간과 시작시간이 같은 경우에는 시간이 겹친다고 말하지 않는다. 

    회의의 개수 N과 각 회의의 시작시간, 종료시간이 주어졌을 때 되도록 많은 회의를 개최하고자 한다.
    회의를 최대한 많이 배정하는 프로그램을 작성하시오.

    입력형식:
    첫줄에는 회의의 수 N(5≤N≤500)가 주어진다.
    다음 N줄에 걸쳐, 각 회의의 번호와 시작시간과 종료시간이 차례로 주어진다. (500 이하의 자연수)
    한 회의에서 시작시간과 종료시간이 같은 경우는 주어지지 않는다.

    출력형식:
    첫줄에는 배정 가능한 최대의 회의수를 출력하고 다음 줄부터는 배정한 회의의 번호를 시간대순으로 출력한다.
    만약, 답이 여러 가지(최대회의수가 될 수 있는 배정 방법이 여러가지)라면 그 중 아무거나 하나 출력한다.

    입력:
    6
    1 1 10
    2 5 6
    3 13 15
    4 14 17
    5 8 14
    6 3 12

    출력:
    3
    2 5 4
*/

import java.util.*;

class Main {
    class Room {
      int id; // 회의실 번호
      int start; // 회의 시작 시간
      int end; // 회의 종료 시간
      Room() {id = start = end = 0;}
      Room(int id, int start, int end) {
        this.id = id;
        this.start = start;
        this.end = end;
    }
  }

  int n;
  Room[] room;
  int[] A;
  
  void Input() {
    Scanner in = new Scanner(System.in);
    n = in.nextInt(); // 회의 수 N
    room = new Room[500 + 10];
    for (int i = 0; i < n; i++) {
      room[i] = new Room(in.nextInt(), in.nextInt(), in.nextInt());
    }
    in.close();
  }

  int Solve() {
        // 2. 회의종료시간을 기준으로 오름차순으로 정렬(예외처리)
    for (int i = 0; i < n-1; i++) {
      for (int j = i+1; j < n; j++) {
        if (room[i].end > room[j].end) {
          Room tmp = room[i];
          room[i] = room[j];
          room[j] = tmp;
        }
      }
    }
    
    // 3. 가장 먼저 끝나는 회의 시간과 다음 회의의 시작시간을 비교해서 같거나 늦으면 count++하고 room id를 배열에 저장한다.
    int count = 1; // room[0]은 미리 카운트한다.
    int poll = 0, idx = 0;
    A = new int[n + 1];
    A[idx++] = room[0].id;
    
    for (int i = 1; i < n; i++) {
      //System.out.println("room["+poll+"].end = " + room[poll].end);
      //System.out.println("room["+i+"].start = " + room[i].start);
      if (room[poll].end <= room[i].start) {
        //System.out.println("[OK]");
        count++; // room 수 증가
        poll = i; // 선택된 room의 인덱스를 기준으로 변경
        A[idx] = room[i].id; // 선택된 회의실의 id를 별도로 저장함
        //System.out.println("count = " + count);
        //System.out.println("room["+i+"].id = " + room[i].id);
        //System.out.println("A["+idx+"] = " + A[idx]);
        idx++;
      } else {
        //System.out.println("[NG]");
      }
      //System.out.println("--------------------------------");
    }
    return count;
  }
  
  public static void main(String[] args) {
    Main m = new Main();
    m.Input();
    int ans = m.Solve();

    // 5. 결과값 출력
    System.out.println(ans);
    for (int i = 0; i < ans; i++) {
      System.out.print(m.A[i] + " ");
    }
  }
}
