/*
1. 씨름 선수
설명
현수는 씨름 감독입니다. 현수는 씨름 선수를 선발공고를 냈고, N명의 지원자가 지원을 했습니다.
현수는 각 지원자의 키와 몸무게 정보를 알고 있습니다.
현수는 씨름 선수 선발 원칙을 다음과 같이 정했습니다.
“A라는 지원자를 다른 모든 지원자와 일대일 비교해서 키와 몸무게 모두 A지원자 보다 높은(크고, 무겁다) 지원자가
존재하면 A지원자는 탈락하고, 그렇지 않으면 선발된다.”
N명의 지원자가 주어지면 위의 선발원칙으로 최대 몇 명의 선수를 선발할 수 있는지 알아내는 프로그램을 작성하세요.

입력
첫째 줄에 지원자의 수 N(5<=N<=30,000)이 주어집니다.
두 번째 줄부터 N명의 흰돌 능력치와 검은돌 능력치 정보가 차례로 주어집니다.
각 선수의 흰돌능력치가 모두 다르고, 검은돌 능력치도 모두 다릅니다. 능력치 값은 1,000,000이하의 자연수입니다.

출력
첫째 줄에 바둑 선수로 뽑히는 최대 인원을 출력하세요.

예시 입력 1 
5
172 67
183 65
180 70
170 72
181 60

예시 출력 1
3
*/
import java.util.*;

// ArrayList sort 하는 방법1.
class Player implements Comparable<Player> {
    int h;
    int w;
    Player(int h, int w) {
        this.h = h;
        this.w = w;
    }
    @Override
    public int compareTo(Player o) { // 키를 기준으로 정렬함.
        return o.h - this.h;
    }
}

/*
1. class Player를 만들어서 사용한다.
2. 배열이 아니라 ArrayList<Player>를 사용한다.
3. 키나 몸무게 중 하나라도 다른 사람보다 우위에 있으면 출전을 한다.
4. 키를 기준으로 ArrayList를 내림차순으로 정렬을 한다.
5. ArrayList 정렬방법

*/
public class Main {  
    static int n;
    static int[] weight;
    static int[] height;
    static ArrayList<Player> arr;
    
    public void inputData() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        arr = new ArrayList<>();

        for (int i=0; i<n; i++) {
            int h = in.nextInt();
            int w = in.nextInt();
            arr.add(new Player(h, w));
        }
    }

    
    public int solution() {
        int answer = 0;
        Collections.sort(arr); // 내림차순 정렬
        int max = Integer.MIN_VALUE;
        for (Player p : arr) {
            //System.out.println("h= "+p.h+", w= "+p.w);
            if (p.w > max) {
                max = p.w;
                answer++;
            }
        }
 
        return answer;
    }
    
    public static void main(String[] args) {
        Main T = new Main();
        T.inputData();
        System.out.println(T.solution());
        //System.out.println(answer);
    }
}

