import sys

def DFS(s):
    if a[s]>0:
        return a[s]
    if s==1 or s==2:
        return s
    else:
        a[s]=DFS(s-1)+DFS(s-2)
        return a[s]


if __name__=="__main__":
    n=int(sys.stdin.readline())
    a=[0]*(n+1)
    print(DFS(n))