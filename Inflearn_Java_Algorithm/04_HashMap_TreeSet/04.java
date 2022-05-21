 /*
4. 모든 아나그램 찾기
설명
S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.
아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.

입력
첫 줄에 첫 번째 S문자열이 입력되고, 두 번째 줄에 T문자열이 입력됩니다.
S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같습니다.

출력
S단어에 T문자열과 아나그램이 되는 부분문자열의 개수를 출력합니다.

예시 입력 1 
bacaAacba
abc

예시 출력 1
3
*/

import java.util.*;

public class Main {
    String  S, T;    
    
    public void inputData() {
        Scanner in = new Scanner(System.in);
        S = in.next();
        T = in.next();
        in.close();
    }

  /*
    1. HashMap, Sliding window, Two pointer 사용한다.
    2. 아나그램 비교는 equals를 사용하면 된다.
  */
    public int solve() {
        int answer = 0;
        // S문자열에서 3개씩 잘라낸 단어의 해쉬맵
        HashMap<Character, Integer> am = new HashMap<>();
        // 비교를 위한 T문자열의 해쉬맵
        HashMap<Character, Integer> bm = new HashMap<>();

        // 1. 비교를 위해 초기값을 세팅한다. (len-1개 만큼)
        // T = "abc"
        for (char x : T.toCharArray()) {
            // bm 해쉬맵에서 x키를 읽어서 값이 있으면 ++해서 업데이트 한다.
            // 값이 없으면 +1에서 저장한다.
            bm.put(x, bm.getOrDefault(x, 0)+1);
        }

        // T문자열의 길이-1을해서 초기루틴을 만든다. -1을 하는 이유는 rt를 증가시킨 후 비교하는 루틴이기 때문이다.
        int L = T.length()-1;
        for (int i=0; i<L; i++) {
            // 특정 길이만큼만 돌려야 하기에 그냥 for문을 사용한다.
            // S문자열에서 한개씩 비교하기 위해 charAt(i)를 사용한다.
            // am 해쉬맵에서 한글자씩 읽어서 값이 있으면 ++해서 업데이트한다.
            am.put(S.charAt(i), am.getOrDefault(S.charAt(i), 0)+1);
        }


        // 2. 투포인트 알고리즘을 돌린다.
        int lt=0;
        for (int rt=L; rt<S.length(); rt++) {
            // 2-1. am해쉬맵에 같은 문자키가 있으면 ++해서 업데이트 한다.
            am.put(S.charAt(rt), am.getOrDefault(S.charAt(rt), 0)+1);
            // am과 bm이 값으면 answer++한다.
            if (am.equals(bm))
                answer++;

            // 2-2. am해쉬맵에서 lt키값을 찾아서 --해서 업데이트 한다.
            am.put(S.charAt(lt), am.get(S.charAt(lt))-1);
            // 만약 값이 0이면 equals했을 때 값이 달라지므로 값을 제거해야 한다.
            if (am.get(S.charAt(lt))==0)
                am.remove(S.charAt(lt));
            lt++; // 모든 처리가 끝나면 lt를 한칸 증가시킨다.
        }
        return answer;
    }


    public static void main(String[] args) {
        Main m = new Main();
        m.inputData();
        //for (int x : m.solve()) {
        //    System.out.print(x + " ");
        //}
        System.out.println(m.solve());
    }
}
