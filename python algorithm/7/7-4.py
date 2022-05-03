import sys

def DFS(L, sum):
    global cnt
    if sum>T:
        return
    if L==k:
        if sum==T:
            cnt+=1
    else:
        for i in range(n[L]+1):
            DFS(L+1, sum+p[L]*i)

if __name__=="__main__":
    T = int(sys.stdin.readline())
    k = int(sys.stdin.readline())
    p=[]
    n=[]
    for i in range(k):
        a, b = map(int, sys.stdin.readline().split())
        p.append(a)
        n.append(b)
    cnt=0
    DFS(0,0)
    print(cnt)