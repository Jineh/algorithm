import sys

while 1:
    try:
        h,m = map(int,sys.stdin.readline().split())
        print(h+m)
    except:
        break