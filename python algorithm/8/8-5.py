import sys


n=int(sys.stdin.readline())
arr=list(map(int, sys.stdin.readline().split()))
arr.insert(0,0)
dy=[0]*(n+1)
dy[1]=1
res=0
for i in range(2, n+1):         # 끝자리
    max=0
    for j in range(i-1, 0, -1):
        if arr[j]<arr[i] and dy[j]>max:     # 앞에 숫자 중 작은 값
            max=dy[j]
    dy[i]=max+1
    if dy[i]>res:
        res=dy[i]
print(res)
