import sys

n =int(sys.stdin.readline())

for i in range(n):
    N, s, e, k = map(int, sys.stdin.readline().split())
    a = list(map(int,sys.stdin.readline().split()))

    a = a[s-1:e]
    a.sort()
    print("#"+"%d %d" %(i+1,a[k-1]))  

