import sys
n=int(sys.stdin.readline())

for _ in range(n):
    a=list(map(int, sys.stdin.readline().split()))
    n=a[0]
    avg=(sum(a)-n)/n
    cnt=0
    for i in a[1:]:
        if i > avg:
            cnt+=1
    rate = cnt/n*100
    print(f'{rate:.3f}%')