# 모르겠다...

import sys

def DFS(L, sum):
    global res
    if L==n:
        if 0<sum<=s:
            res.add(sum)        # 중복인 경우 없애기 위해 set
    else:
        DFS(L+1, sum+G[L])      # 추가 왼쪽
        DFS(L+1, sum-G[L])      # 추가 오른쪽
        DFS(L+1, sum)           # 추 없음

if __name__=="__main__":
    n=int(sys.stdin.readline())
    G=list(map(int, sys.stdin.readline().split()))
    s=sum(G)
    res=set()
    DFS(0, 0)
    print(s-len(res))