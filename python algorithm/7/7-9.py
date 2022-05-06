import sys
from collections import deque
dx=[-1, 0, 1, 0]
dy=[0, 1, 0, -1]
n=7
board=[list(map(int, sys.stdin.readline().split())) for _ in range(7)]
dis=[[0]*n for _ in range(n)]
Q=deque()
Q.append((0,0))
board[0][0]=1
while Q:
    tmp = Q.popleft()
    for i in range(4):
        x=tmp[0] + dx[i]
        y=tmp[1] + dy[i]
        if 0<=x<=6 and 0<=y<=6 and board[x][y]==0:
            board[x][y]=1       # 지난 곳 벽으로 바꾸기
            dis[x][y]=dis[tmp[0]][tmp[1]]+1         # 지나온 거리 누적 값
            Q.append((x,y))
if dis[6][6]==0:
    print(-1)
else:
    print(dis[6][6])        # 최단 거리여서 이미 지나온 거리는 벽을 만듦