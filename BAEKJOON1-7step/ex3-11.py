import sys
h,m = map(int,sys.stdin.readline().split())
n = list(map(int,sys.stdin.readline().split()))

for i in range(h):
   if n[i]<m:
      print(n[i], end=" ")