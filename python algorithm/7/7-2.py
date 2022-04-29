import sys

def DFS(L, sum):
    global res
    if L>n:         # 기한 넘어가면 리턴
        return
    if L==n:        
        if sum>res:
            res=sum
    else:
        DFS(L+pt[L], sum+pv[L])         # 상담 포함
        DFS(L+1, sum)                   # 상담 미포함


if __name__=="__main__":
    n= int(sys.stdin.readline())
    pv=[]
    pt=[]
    for _ in range(n):
        a, b = map(int, sys.stdin.readline().split())
        pt.append(a)
        pv.append(b)
    res=0
    DFS(0, 0)
    print(res)
