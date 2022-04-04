import sys
import heapq as hq
a=[]        # 리스트에 트리 형태로 저장 
while True:
    n= int(sys.stdin.readline())
    if n==-1:
        break
    if n==0:
        if len(a)==0:   
            print(-1)
        else:
            print(-hq.heappop(a))   # 출력시 음수 -> 양수로 출력
    else:
        hq.heappush(a, -n)      # 힙은 최소힙으로만 작동