import sys

def DFS(L, sum, tsum):
    global result                   # 전역 변수 선언
    if sum+(total-tsum)<result:     # total에서 지금까지 지나온 값 빼면 앞으로 합칠 값 남음
        return                      # 여기서 sum 합치면 남은 값 + 더한 값 
    if sum>c:
        return
    if L==n:
        if sum>result:
            result=sum
    else:
        DFS(L+1, sum+a[L], tsum+a[L])
        DFS(L+1, sum, tsum+a[L])

if __name__=="__main__":
    c, n = map(int, sys.stdin.readline().split())
    a=[]
    result=0
    for _ in range(n):
        a.append(int(sys.stdin.readline()))
    total=sum(a)
    DFS(0, 0, 0)
    print(result)