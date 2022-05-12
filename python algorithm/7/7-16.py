import sys

def DFS(x,y):
    ch[x][y]=1
    if x==0:
        print(y)
    else:           # 왼, 오른쪽이 우선
        if 0<=y-1 and board[x][y-1]==1 and ch[x][y-1]==0:
            DFS(x, y-1)
        elif y+1<10 and board[x][y+1]==1 and ch[x][y+1]==0:
            DFS(x, y+1)
        else:
            DFS(x-1, y)

if __name__=="__main__":
    board=[list(map(int, sys.stdin.readline().split())) for _ in range(10)]
    ch = [[0]*10 for _ in range(10)]
    for y in range(10):
        if board[9][y]==2:      # 찾는 위치에서 시작
            DFS(9, y)