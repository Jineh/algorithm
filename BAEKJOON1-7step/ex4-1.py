import sys

while 1:
    h,m = map(int,sys.stdin.readline().split())
    if(h==0 and m==0):
        break
    print(h+m)