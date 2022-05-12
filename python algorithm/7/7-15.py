import sys
from collections import deque

dx=[-1, 0, 1, 0]
dy=[0, 1, 0, -1]
m, n = map(int, sys.stdin.readline().split())
board=[list(map(int, sys.stdin.readline().split())) for _ in range(n)]
Q = deque()
dis=[[0]*m for _ in range(n)]
for i in range(n):
    for j in range(m):
        if board[i][j]==1:
            Q.append((i, j))

while Q:
    a, b = Q.popleft()
    for k in range(4):
        x=a+dx[k]
        y=b+dy[k]
        if 0<=x<n and 0<=y<m and board[x][y]==0:
            board[x][y]=1
            dis[x][y]=dis[a][b]+1       # 누적 값 더함
            Q.append((x, y))

flag=1
for i in range(n):
    for j in range(m):
        if board[i][j]==0:      # 익을 수 없는 상태
            flag=0
result=0
if flag==1:
    for i in range(n):          # 최댓값 찾기 누적값
        for j in range(m):
            if dis[i][j]>result:
                result=dis[i][j]
    print(result)
else:
    print(-1)
