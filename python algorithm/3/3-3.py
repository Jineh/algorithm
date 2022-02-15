import sys

a=list(range(21))   # 0-20 배열
for _ in range(10):
    s, e = map(int, sys.stdin.readline().split())
    for i in range((e-s+1)//2):
        a[s+i], a[e-i] = a[e-i], a[s+i]
a.pop(0) 
for x in a:
    print(x, end=' ')