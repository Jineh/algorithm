import sys

def Count(len):     # 모든 선을 mid 값으로 나눠서 얻는 선 개수 리턴
    cnt=0
    for x in Line:
        cnt+=(x//len)
    return cnt

k, n = map(int, sys.stdin.readline().split())
Line=[]
res=0
largest=0
for i in range(k):
    tmp=int(sys.stdin.readline())
    Line.append(tmp)
    largest=max(largest, tmp)   # 가장 큰 값으로 길이 선택
lt=1
rt=largest
while lt<=rt:   # 이분법으로 찾기
    mid=(lt+rt)//2
    if Count(mid)>=n:   # n보다 크거나 같으면 성공
        res=mid
        lt=mid+1
    else:
        rt=mid-1
print(res)