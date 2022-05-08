import sys

def DFS(x,y,v):
    global cnt
    if x==ex and y==ey:
        cnt+=1
    else:
        for i in range(4):
            xx= x+dx[i]
            yy= y+dy[i]
            if 0<=xx<n and 0<=yy<n and v<board[xx][yy] and ch[xx][yy]==0:
                ch[xx][yy]=1
                DFS(xx,yy,board[xx][yy])
                ch[xx][yy]=0


if __name__=="__main__":
    n= int(sys.stdin.readline())
    dx=[-1, 0, 1, 0]
    dy=[0, 1, 0, -1]
    board=[[0]*n for _ in range(n)]
    ch=[[0]*n for _ in range(n)]
    max=-2147000000
    min=2147000000
    for i in range(n):      # 최대, 최솟값 구하기 위해서 따로 리스트 받고 행 마다 값 구함
        tmp = list(map(int, sys.stdin.readline().split()))
        for j in range(n):
            if tmp[j]<min:
                min=tmp[j]
                sx=i
                sy=j
            if tmp[j]>max:
                max=tmp[j]
                ex=i
                ey=j
            board[i][j]=tmp[j]
    ch[sx][sy]=1
    cnt=0
    DFS(sx,sy,board[sx][sy])
    print(cnt)