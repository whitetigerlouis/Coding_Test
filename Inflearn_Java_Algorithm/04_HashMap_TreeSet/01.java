 /*
1. 학급 회장(해쉬)
설명
학급 회장을 뽑는데 후보로 기호 A, B, C, D, E 후보가 등록을 했습니다.
투표용지에는 반 학생들이 자기가 선택한 후보의 기호(알파벳)가 쓰여져 있으며 선생님은 그 기호를 발표하고 있습니다.
선생님의 발표가 끝난 후 어떤 기호의 후보가 학급 회장이 되었는지 출력하는 프로그램을 작성하세요.
반드시 한 명의 학급회장이 선출되도록 투표결과가 나왔다고 가정합니다.

입력
첫 줄에는 반 학생수 N(5<=N<=50)이 주어집니다.
두 번째 줄에 N개의 투표용지에 쓰여져 있던 각 후보의 기호가 선생님이 발표한 순서대로 문자열로 입력됩니다.

출력
학급 회장으로 선택된 기호를 출력합니다.

예시 입력 1 
15
BACBACCACCBDEDE

예시 출력 1
C
*/

import java.util.*;

public class Main {
    int n;
    String str = new String();
    
    public void inputData() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        str = in.next();
        in.close();
    }

  /*
    1. 최대 매출액 변수를 정해서 계속 업데이트 하자
    2. 입력범위가 100,000,000이면 이중루프를 돌리면 time out이 난다.
    3. two pointer 문제
  */
    public char solve() {
        char answer = ' ';
        int max = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : str.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0)+1);    
        }

        for (char key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }
        /*
        int[] cnt = new int[5];
        char[] ch = str.toCharArray();

        for (int i = 0; i < n; i++) {
            if (ch[i] == 'A') {
                cnt[0]++;
            } else if (ch[i] == 'B') {
                cnt[1]++;
            } else if (ch[i] == 'C') {
                cnt[2]++;
            } else if (ch[i] == 'D') {
                cnt[3]++;
            } else if (ch[i] == 'E') {
                cnt[4]++;
            }
        }

        for (int i = 0; i < 5; i++) {
            if (max < cnt[i]) {
                max = cnt[i];
                answer = find(i);
            }
        }
        */
        return answer;
    }

    /*
    public char find(int num) {
        char ch = ' ';
        switch(num) {
            case 0:
                ch = 'A';
                break;
            case 1:
                ch = 'B';
                break;
            case 2:
                ch = 'C';
                break;
            case 3:
                ch = 'D';
                break;
            case 4:
                ch = 'E';
                break;
            default:
                break;
        }
        return ch;
    }
    */

    public static void main(String[] args) {
        Main m = new Main();
        m.inputData();
        //for (int x : m.solve()) {
        //    System.out.print(x + " ");
        //}
        System.out.println(m.solve());
    }
}
