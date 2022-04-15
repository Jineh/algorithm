import sys

def DFS(L, sum):
    if L==n and sum==f:
        for x in p:
            print(x, end=' ')
        sys.exit(0)     # 오름차순이라 처음 값이 정답
    else:
        for i in range(1, n+1):
            if ch[i]==0:    # 조합은 순서 필요
                ch[i]=1
                p[L]=i
                DFS(L+1, sum+(p[L]*b[L]))
                ch[i]=0
    
if __name__=="__main__":
    n, f = map(int, sys.stdin.readline().split())
    p=[0]*n
    b=[1]*n
    ch=[0]*(n+1)
    for i in range(1, n):
        b[i]=b[i-1]*(n-i)//i    # 조합 계산법
    DFS(0, 0)