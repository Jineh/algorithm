import sys

def DFS(len):
    if dy[len]>0:       # 가지치기
        return dy[len]
    if len==1 or len==2:
        return len
    else:
        dy[len]=DFS(len-1)+DFS(len-2)       # 메모이제이션
        return dy[len]

if __name__=="__main__":
    n=int(sys.stdin.readline())
    dy=[0]*(n+1)
    print(DFS(n))