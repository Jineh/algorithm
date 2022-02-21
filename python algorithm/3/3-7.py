import sys

n = int(sys.stdin.readline())
a=[list(map(int, sys.stdin.readline().split()))for _ in range(n)]   # n번 이중 배열

res=0
s=e= n//2       # 다이아 절반 
for i in range(n):
        for j in range(s, e+1):
                res+=a[i][j]
        if i<n//2:
                s-=1
                e+=1
        else:
                s+=1
                e-=1
print(res)