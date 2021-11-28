import sys
n=int(sys.stdin.readline())
a=list(map(int, sys.stdin.readline().split()))
max=max(a)

for i in range(n):
    a[i]=a[i]/max*100
print(sum(a)/n)