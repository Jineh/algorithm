import sys

n, m = map(int, sys.stdin.readline().split())
a = list(map(int, sys.stdin.readline().split()))
lt=0
rt=1
tot=a[0]
count =0 

# 두 개의 포인터로 이동
while True:
    if tot<m:
        if rt<n:    # 맨 끝을 가리키면 break
            tot+=a[rt]
            rt+=1
        else:
            break
    elif tot == m:
        count+=1
        tot -=a[lt]
        lt+=1
    else:
        tot -=a[lt]
        lt+=1

print(count)