import sys
n=int(sys.stdin.readline())

for i in range(n):
   h,m = map(int,sys.stdin.readline().split())
   print(h+m)