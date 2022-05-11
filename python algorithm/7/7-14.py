import sys
sys.setrecursionlimit(10**6)

dx=[1, 0, -1, 0]
dy=[0, 1, 0, -1]


def DFS(x, y, h):
    ch[x][y]=1
    for i in range(4):
        xx=x+dx[i]
        yy=y+dy[i]
        if 0<=xx<n and 0<=yy<n and ch[xx][yy]==0 and board[xx][yy]>h:
            DFS(xx, yy, h)


if __name__=="__main__":
    n=int(sys.stdin.readline())
    cnt=0
    res=0
    board=[list(map(int, sys.stdin.readline().split())) for _ in range(n)]
    for h in range(100):        # 물 높이 
        ch=[[0]*n for _ in range(n)]
        cnt=0
        for i in range(n):
            for j in range(n):
                if ch[i][j]==0 and board[i][j]>h:   # 안전지대 발견
                    cnt+=1
                    DFS(i, j, h)
        res=max(res, cnt)
        if cnt==0:      # 최대 지대보다 높은 곳이 없으면 안전지대가 없으니 종료
            break
    print(res)

