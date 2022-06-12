1. 메모이제이션(피보나치 수열)
    static int[] fibo;
    public int DFS(int n){
        if(fibo[n]>0) return fibo[n]; // 이미 기록된 값이면 그 값을 바로 리턴함.
        if(n==1)
            return fibo[n] = 1;
        else if(n==2)
            return fibo[n] = 1;
        else {
            return fibo[n] = DFS(n-2) + DFS(n-1);
        }
    }

2. 이진트리순회(DFS)
    Node root;
    public void DFS(Node root){
        if(root == null) return;// 말단에 연결된 노드가 없으면 리턴
        else {
            //System.out.print(root.data+" ");
            DFS(root.lt);
            //System.out.print(root.data+" ");
            DFS(root.rt);
            System.out.print(root.data+" ");
        }
    }

