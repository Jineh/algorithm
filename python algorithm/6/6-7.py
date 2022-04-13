import sys

def DFS(sum, cnt):
    global result
    if cnt>=result:     # 최소값보다 크면 더이상 더할 필요 없음
        return
    if sum>m:
        return
    elif sum==m:
        if result>cnt:
            result=cnt
    else:
        for i in a:
            DFS(sum+i, cnt+1)


if __name__=="__main__":
    n = int(sys.stdin.readline())
    a = list(map(int, sys.stdin.readline().split()))
    m = int(sys.stdin.readline())
    result=2147000000
    a.sort(reverse=True)        # 내림차순으로 큰 값이 많이 더해 질 수록 적은 동전이 사용됨
    DFS(0, 0)
    print(result)