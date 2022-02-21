import sys

n= int(sys.stdin.readline())
a=[list(map(int, sys.stdin.readline().split()))for _ in range(n)]   # n번 이중 배열

largest=0
for i in range(n):
    sum1=sum2=0
    for j in range(n):
        sum1+=a[i][j]   # 행 합
        sum2+=a[j][i]   # 열 합
    if sum1>largest:
        largest=sum1
    if sum2>largest:
        largest=sum2
sum1=sum2=0
for i in range(n):
    sum1+=a[i][i]
    sum2+=a[i][n-i-1]
if sum1>largest:
    largest=sum1
if sum2>largest:
    largest=sum2
print(largest)





