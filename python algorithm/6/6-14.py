import sys

n = int(sys.stdin.readline())
m= int(sys.stdin.readline())
g=[[0]*(n+1) for _ in range(n+1)]       # 이차원 배열
for i in range(m):
    a, b = map(int, sys.stdin.readline().split())
    g[a][b]=1
    g[b][a]=1

for i in range(1, n+1):
    for j in range(1, n+1):
        print(g[i][j], end=' ')
    print()