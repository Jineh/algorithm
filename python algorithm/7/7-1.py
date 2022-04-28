import sys

def DFS(L, sum, time):
    global res
    if time > m:            # 시간이 오버되면 바로 리턴 
        return
    if L == n:              # 마지막 문제 판별
        if sum>res:
            res=sum
    else:
        DFS(L+1, sum+pv[L], time+pt[L])         # 푼 문제
        DFS(L+1, sum, time)                     # 안 푼 문제

if __name__=="__main__":
    n, m = map(int, sys.stdin.readline().split())
    pv=[]
    pt=[]
    for i in range(n):
        a, b=map(int, sys.stdin.readline().split())
        pv.append(a)
        pt.append(b)
    res=0
    DFS(0, 0, 0)
    print(res)