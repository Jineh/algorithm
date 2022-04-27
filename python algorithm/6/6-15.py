import sys

def DFS(v):
    global cnt
    if v==n:        # n번째 종료 조건
        cnt+=1
    else:
        for i in range(1, n+1):
            if g[v][i]==1 and ch[i]==0:     # 경로, 지나지 않은지 확인
                ch[i]=1
                DFS(i)
                ch[i]=0                     # 돌아갈 때 체크 풀기

if __name__ == "__main__":
    n, m = map(int, sys.stdin.readline().split())
    g=[[0]*(n+1) for _ in range(n+1)]
    ch=[0]*(n+1)
    for i in range(m):
        a, b = map(int, sys.stdin.readline().split())
        g[a][b]=1
    cnt=0
    ch[1]=1
    DFS(1)
    print(cnt)