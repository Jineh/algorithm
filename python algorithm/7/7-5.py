import sys

def DFS(L, a, b, c):
    global res
    if L==n:
        if a!=b and b!=c and a!=c:
            val=[a, b, c]
            val.sort()
            myVal = val[2]-val[0]
            if res> myVal:
                res=myVal
        else:
            return
    else:
        DFS(L+1, a+coin[L], b, c)
        DFS(L+1, a, b+coin[L], c)
        DFS(L+1, a, b, c+coin[L])



if __name__=="__main__":
    n=int(sys.stdin.readline())
    coin=[]
    for i in range(n):
        coin.append(int(sys.stdin.readline()))
    res=2000000
    DFS(0, 0, 0, 0)
    print(res)