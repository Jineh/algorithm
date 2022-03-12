import sys
n, m = map(int, sys.stdin.readline().split())
a = list(map(int, sys.stdin.readline().split()))
a.sort()
lt=0    # 시작, 끝 포인터
rt=n-1
while lt<=rt:   # 시작이 끝 넘어서면 종료
    mid=(lt + rt)//2
    if a[mid]==m:
        print(mid+1)
        break
    elif a[mid]>m:
        rt=mid-1
    else:
        lt=mid+1