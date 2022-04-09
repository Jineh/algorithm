import sys

def DFS(L, sum):
    if sum>total//2:    # 현제 총 합이 토탈 절반 보다 크면 같은 합이 될 수 없으니 -> 시간 복잡도를 줄여줌
        return
    if L==n:                    # 종료 조건
        if sum==(total-sum):    # 토탈에서 총합을 뺀값이 같아야 같은 합이 됨
            print("YES")
            sys.exit(0)         # 프로그램 아예 종료
    else:
        DFS(L+1, sum+a[L])      # 총합에 이전 값 포함
        DFS(L+1, sum)           # 미포함

if __name__=="__main__":
    n=int(sys.stdin.readline())
    a=list(map(int, sys.stdin.readline().split()))
    total=sum(a)
    DFS(0, 0)
    print("NO")