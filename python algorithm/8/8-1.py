import sys

n=int(sys.stdin.readline())
dy=[0]*(n+1)
dy[1]=1         # 이미 아는값은 직접 설정
dy[2]=2
for i in range(3, n+1):
    dy[i]=dy[i-1]+dy[i-2] # 피보나치 수열

print(dy[n])