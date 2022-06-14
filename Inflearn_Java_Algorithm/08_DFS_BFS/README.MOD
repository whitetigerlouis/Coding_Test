1. 메모이제이션
    int[][] dy = new int[35][35];
    public int DFS(int n, int r) {
        if (dy[n][r]>0) // 메모이제이션에 값이 있으면 그걸 바로 리턴한다
            return dy[n][r];
        
        if (n==r || r==0) 
            return 1;
        else 
            return dy[n][r] = DFS(n-1, r-1) + DFS(n-1, r);
    }
