import sys

def DFS(L):
    global cnt
    if L==m:    # 리스트 크기가 m 일떄 종료
        for i in range(m):
            print(res[i], end=' ')
        print()
        cnt+=1
    else:
        for i in range(1, n+1):     # 1부터 순서대로 리스트에 삽입
            res[L]=i
            DFS(L+1)

if __name__=="__main__":
    n, m = map(int, sys.stdin.readline().split())
    res=[0]*n
    cnt=0
    DFS(0)
    print(cnt)

