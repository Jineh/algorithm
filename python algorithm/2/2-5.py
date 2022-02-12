import sys

N, M = map(int, sys.stdin.readline().split())
a=[0]*(N+M+3)   # 배열 초기화
max=0
for i in range(1, N+1):
    for j in range(1, M+1):
        a[i+j]+=1
for i in range(N+M+1):
    if a[i]>max:
        max=a[i]
for i in range(N+M+1):
    if a[i]==max:
        print(i, end='')
