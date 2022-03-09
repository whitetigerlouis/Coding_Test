/*
  N : 얼음틀의 세로 길이
  M : 얼음틀의 가로 길이
  (1 <= N, M <= 1,000)
  두번째 줄부터 N + 1번째 줄까지 얼음 틀의 형태가 주어진다.
  구멍이 뚫려 있는 부분은 0, 칸막이 부분은 1이다.
  구멍이 뚫려 있는 부분끼리 상, 하, 좌, 우로 붙어 있는 경우 연결된 것으로 간주한다.
  생성되는 총 아이스크림의 개수를 구하라.
*/
import java.util.*;

public class Main {
  public static int n, m;
  public static int[][] graph = new int[1000][1000];

  // DFS알고리즘
  // 헷갈림을 방지하지 위해 2차 행렬 순서를 [y축][x축]으로 설정함
  public static boolean dfs(int y, int x) {
    // 재귀함수 종료조건
    // 배열 인덱스가 0부터 시작하니까 -1이면 범위 벗어난 것으로 판단함
    // 배열 크기가 [0 ~ n-1][0 ~ m-1]이므로 n, m이 나오면 범위 오버.
    if (x <= -1 || x >= n || y <= -1 || y >= m) {
      System.out.println("graph["+y+"]["+x+"] is Out of bound!");
      return false;
    }

    // 현재 노드를 아직 방문하지 않았다면
    if (graph[y][x] == 0) {
      // 1. 해당 노드를 방문 처리
      graph[y][x] = 1;
      System.out.println("graph["+y+"]["+x+"] is NOT visited!");
      System.out.println("graph["+y+"]["+x+"] 방문처리 0 -> 1");

      // 상, 하, 좌, 우의 위치들도 방문이 가능한지 재귀호출로 확인
      System.out.println("상/하/좌/우 체킹 시작");
      dfs(y-1, x);
      dfs(y+1, x);
      dfs(y, x-1);
      dfs(y, x+1);
      
      return true;
    }
    System.out.println("graph["+y+"]["+x+"] is visited.");
    return false;
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // N, M을 공백을 기준으로 구분하여 입력 받기
    n = sc.nextInt();
    m = sc.nextInt();
    sc.nextLine(); // 버퍼 지우기

    // 2차원 리스트의 맵 정보 입력 받기
    for (int i = 0; i < n; i++) {
      String str = sc.nextLine();
      for (int j = 0; j < m; j++) {
        graph[i][j] = str.charAt(j) - '0'; // 입력받은 문자열을 int로 캐스팅하기
      }
    }

    // 모든 노드 대해 음료수 채우기
    int result = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        // 현재 위치에서 빠짐없이 dfs실행
        if (dfs(i,j)) {
          result += 1; // 만들어진 아이스크림 개수
          System.out.println("result = " + result);
        }
      }
    }
    System.out.println(result);
  }
}
