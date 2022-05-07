import sys
from collections import deque

def DFS(x, y):
    global cnt
    if x==6 and y==6:
        cnt+=1
    else:
        for i in range(4):
            mx=x+dx[i]
            my=y+dy[i]
            if 0<=mx<=6 and 0<=my<=6 and board[mx][my]==0:
                board[mx][my]=1
                DFS(mx, my)
                board[mx][my]=0
        

if __name__=="__main__":
    dx=[-1, 0, 1, 0]
    dy=[0, 1, 0, -1]
    board=[list(map(int, sys.stdin.readline().split())) for _ in range(7)]
    board[0][0]=1
    cnt=0
    DFS(0,0)
    print(cnt)