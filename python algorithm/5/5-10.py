import sys
import heapq as hq
a=[]        # 리스트에 트리 형태로 저장 
while True:
    n= int(sys.stdin.readline())
    if n==-1:
        break
    if n==0:
        if len(a)==0:   # 리스트 빈 값인지 확인
            print(-1)
        else:
            print(hq.heappop(a))
    else:
        hq.heappush(a, n)