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
