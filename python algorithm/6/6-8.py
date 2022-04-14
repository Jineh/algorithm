import sys

def DFS(L):
    global cnt
    if L==m:
        for i in range(m):
            print(res[i], end=" ")
        cnt+=1              # 순열 배열 출력 후 카운트
        print()
    else:
        for i in range(1, n+1):
            if ch[i]==0:    # 사용된 숫자인지 확인 용
                ch[i]=1
                res[L]=i
                DFS(L+1)
                ch[i]=0     # 사용 후 다시 되돌림

if __name__=="__main__":
    n, m = map(int, sys.stdin.readline().split())
    res=[0]*n
    ch=[0]*(n+1)
    cnt=0
    DFS(0)
    print(cnt)