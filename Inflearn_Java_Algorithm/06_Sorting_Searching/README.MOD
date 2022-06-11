1. 선택정렬
  - 처음부터 비교해서 가장 작은 수를 처음으로 보낸다.
  
2. 버블정렬
  - 연속한 두 수를 비교해서 큰 수를 뒤로 보낸다.
  - 결국 가장 큰 수가 맨 뒤로 가게되고, 처음이 올 때까지 반복한다.
  
3. 삽입정렬
  - j를 역순으로 루프를 돌려서 순차적으로 정렬한다.
  
4. pos자리 앞부터 1칸씩 뒤로 밀기
  for (int i=pos; i>=1; i--)
      cache[i] = cache[i-1];

5. A배열을 오름차순으로 정렬
  Arrays.sort(A);
  
6. x, y 좌표를 정렬하는 방법
class Point implements Comparable<Point>{ // x, y 좌료를 가지는 전용 클래스
    public int x, y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Point o){
        if(this.x == o.x)
            return this.y - o.y;// x축이 같으면 y축 기준 오름차순 정렬
        else
            return this.x - o.x;// x축 기준 오름차순 정렬
    }
}

  Collections.sort(A);
