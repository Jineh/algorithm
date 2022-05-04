import sys
from collections import deque
dx=[-1, 0, 1, 0]
dy=[0, 1, 0, -1]
n=int(sys.stdin.readline())
a=[list(map(int, sys.stdin.readline().split())) for _ in range(n)]
ch=[[0]*n for _ in range(n)]
sum=0
Q=deque()
ch[n//2][n//2]
Q.append((n//2, n//2))      # 중점에서 시작
L=0
while True:
    if L==n//2:
        break
    size=len(Q)
    for i in range(size):
        tmp=Q.popleft()
        for j in range(4):      # 동서남북으로 좌표 추가
            x=tmp[0]+dx[j]
            y=tmp[1]+dy[j]
            if ch[x][y]==0:     # 체크 된 좌표인지 확인
                sum+=a[x][y]
                ch[x][y]=1
                Q.append((x, y))
    L+=1
print(sum)
