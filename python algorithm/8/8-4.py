import sys

n=int(sys.stdin.readline())
dy=[0]*(n+2)
dy[1]=1
dy[2]=2
for i in range(3, n+2):
    dy[i]=dy[i-1]+dy[i-2]
    print(i)

print(dy[n+1])