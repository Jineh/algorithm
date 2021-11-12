import sys
n=int(sys.stdin.readline())

for i in range(1,n+1):
   h,m = map(int,sys.stdin.readline().split())
   print(f'Case #{i}: {h+m}')