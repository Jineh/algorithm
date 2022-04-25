import sys

def DFS(L, s, res):
    global cnt
    if L==k:
        if res%m==0:        # 배수 값 나머지로 확인
            cnt+=1
    else:
        for i in range(s, n):
             DFS(L+1, i+1, res+a[i])        # start, sum 값 같이 보냄


if __name__ == "__main__":
    n, k = map(int, sys.stdin.readline().split())
    a=list(map(int, sys.stdin.readline().split()))
    m=int(sys.stdin.readline())
    cnt=0
    DFS(0, 0, 0)
    print(cnt)