import sys

def DFS(v):
    if v==n+1:
        for i in range(1, n+1):
            if ch[i]==1:    # 포함 값만 출력
                print(i, end=' ')
        print()
    else:
        ch[v]=1     # 부분 집합 포함
        DFS(v+1)
        ch[v]=0     # 부분 집합 미 포함
        DFS(v+1)

if __name__=="__main__":
    n=int(sys.stdin.readline())
    ch=[0]*(n+1)
    DFS(1)