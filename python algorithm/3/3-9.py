import sys

dx=[-1, 0, 1, 0]    # 이동 좌표
dy=[0, 1, 0, -1]
n= int(sys.stdin.readline())
a=[list(map(int, sys.stdin.readline().split())) for _ in range(n)]
a.insert(0, [0]*n)  # 상, 하 0 추가
a.append([0]*n)
for x in a:
    x.insert(0,0)   # 좌, 우 0 추가
    x.append(0)
cnt=0
for i in range(1, n+1):
    for j in range(1, n+1):
        if all(a[i][j]>a[i+dx[k]][j+dy[k]] for k in range(4)):
            # all 모든 조건을 만족해야 참 
            cnt+=1
print(cnt)
