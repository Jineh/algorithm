import sys
def Count(len):
    cnt=1   # 첫 번째 마구간 선택
    ep=a[0]
    for i in range(1,n):
        if a[i]-ep>=len:    # 가까운 마구간 거리가 len 차이
            cnt+=1
            ep=a[i]
    return cnt

n, c = map(int, sys.stdin.readline().split())
a=[]
for _ in range(n):
    a.append(int(sys.stdin.readline()))
a.sort()
lt = 1
rt = a[n-1]
while lt<=rt:
    mid=(lt+rt)//2  # 총 거리에서의 중간 값
    if Count(mid)>=c:
        res=mid
        lt=mid+1
    else:
        rt=mid-1
print(res)

