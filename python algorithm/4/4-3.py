import sys

def Count(c):
    cnt =1
    sum=0
    for x in a:
        if sum+x>c:     # mid 값보다 크면 다음 비디오로 변경
            cnt+=1
            sum=x
        else:
            sum+=x
    return cnt


n, m = map(int, sys.stdin.readline().split())
a = list(map(int, sys.stdin.readline().split()))
lt = 1
rt = sum(a)     # 음악 전체 길이
result = 0
myMax = max(a)
while lt<=rt:
    mid = (lt+rt)//2
    if mid >= myMax and Count(mid)<=m:  # 최대 음악 길이보단 크거나 같아야 함
        result = mid
        rt = mid -1
    else:
        lt = mid+1
print(result)

